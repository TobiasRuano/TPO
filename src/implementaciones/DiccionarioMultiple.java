package implementaciones;

import apis.ABBTDA;
import apis.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	class Elemento{
		int clave;
		int[] valores;
		int cantValores;
	}
	
	Elemento[] elementos;
	int cantClaves;
	
	@Override
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cantClaves = 0;
	}

	@Override
	public void Agregar(int clave, int valor) {
		int posC = Clave2Indice(clave);
		if (posC == -1) {
			posC = cantClaves;
			elementos[posC] = new Elemento();
			elementos[posC].clave = clave;
			elementos[posC].cantValores = 0;
			elementos[posC].valores = new int[100];
			cantClaves++;
		}
		
		Elemento e = elementos[posC];
		int posV = Valor2Indice(e, valor);
		if (posV == -1) {
			e.valores[e.cantValores] = valor;
			e.cantValores++;
		}
	}

	private int Valor2Indice(Elemento e, int valor) {
		int i = e.cantValores-1;
		while (i>=0 && e.valores[i] != valor) {
			i--;
		}
		return i;
	}

	private int Clave2Indice(int clave) {
		int i = cantClaves-1;
		while(i>=0 && elementos[i].clave != clave) {
			i--;
		}
		return i;
	}

	@Override
	public void Eliminar(int clave) {
		int pos = Clave2Indice(clave);
		if (pos != -1) {
			elementos[pos] = elementos[cantClaves-1];
			cantClaves--;
		}
	}

	@Override
	public void EliminarValor(int clave, int valor) {
		int posC = Clave2Indice(clave);
		if (posC != -1) {
			Elemento e = elementos[posC];
			int posV = Valor2Indice(e, valor);
			if (posV != -1) {
				e.valores[posV] = e.valores[e.cantValores-1];
				e.cantValores--;
				if (e.cantValores == 0) {
					Eliminar(clave);
				}
			}
		}
	}

	@Override
	public ABBTDA Recuperar(int clave) {

		ABBTDA arbol = new ABB();
		arbol.InicializarArbol();

		int pos = Clave2Indice(clave);
		if (pos != -1) {
			Elemento e = elementos[pos];
			for (int i = 0; i<e.cantValores; i++) {
				arbol.AgregarElem(e.valores[i]);
			}
		}

		return arbol;
	}

	@Override
	public ABBTDA Claves() {
		
		ABBTDA arbol = new ABB();
		arbol.InicializarArbol();
		for (int i = 0; i<cantClaves; i++) {
			arbol.AgregarElem(elementos[i].clave);
		}
		
		return arbol;
	}

}
