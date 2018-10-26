package implementaciones;

import apis.ABBTDA;
import apis.ConjuntoTDA;
import apis.ColaTDA;
import apis.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	class NodoClave{ 
		int clave;
		ConjuntoLD valores;
		NodoClave sigClave; 
	}
	
	NodoClave origen;
	
	@Override
	public void InicializarDiccionario(){
		origen = null;
	}


	@Override
	public void Agregar(int clave, int valor){ 
		NodoClave nc = Clave2NodoClave(clave); 
		if (nc == null) {
			nc = new NodoClave(); 
			nc.valores = new ConjuntoLD();
			nc.clave = clave;
			nc.sigClave = origen; 
			origen = nc;
		}
		
		if (!nc.valores.Pertenece(valor))
			nc.valores.Agregar(valor);
	}

	private NodoClave Clave2NodoClave (int clave) {
		NodoClave aux = origen;
		while (aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}
	
	public void EliminarValor (int clave, int valor) {
		
		if (origen != null) {
			if (origen.clave == clave) {
				EliminarValorEnNodo(origen, valor);
				
				if (origen.valores.ConjuntoVacio()) {
					origen = origen.sigClave;
				}
			}else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					EliminarValorEnNodo (aux.sigClave, valor);
					if (aux.sigClave.valores.ConjuntoVacio()) {
						aux.sigClave = aux.sigClave.sigClave;
					}
				}
			}
		}
	}

	private void EliminarValorEnNodo (NodoClave nodo, int valor) {
		if (!nodo.valores.ConjuntoVacio()) {
			if (nodo.valores.Pertenece(valor))
				nodo.valores.Sacar(valor);
		}
	}
	
	public void Eliminar (int clave) {
		if (origen != null) {
			if (origen.clave == clave) {
				origen = origen.sigClave;
			}else {
				NodoClave aux = origen;
				while (aux.sigClave != null && aux.sigClave.clave != clave) {
					aux = aux.sigClave;
				}
				if (aux.sigClave != null) {
					aux.sigClave = aux.sigClave.sigClave;
				}
			}
		}
	}
	
	public void Recuperar(int clave, int parametro){ 
		ColaTDA cola = new ColaLD();
		cola.InicializarCola();

		int aux = 0;
		
		NodoClave n = Clave2NodoClave(clave);
		
		ConjuntoTDA copia = new ConjuntoLD();
		copia.InicializarConjunto();
		
		ABBTDA c = new ABB();
		c.InicializarArbol();
		
		if(n != null)
			CopiarConjunto(n.valores, copia);
		
		while (!copia.ConjuntoVacio()) {
			aux = copia.Elegir();
			copia.Sacar(aux);
			c.AgregarElem(aux);
		}
		if (parametro == 1) {
			EnOrdenAscendente(c, cola);
			 
		}else if (parametro == 2) {
			EnOrdenDescendente(c, cola);
		}
		
		while (!cola.ColaVacia()) {
			System.out.println(cola.Primero());
			cola.Desacolar();
		}
	}
	
	private void EnOrdenDescendente(ABBTDA arbol, ColaTDA cola) {
		if (!arbol.ArbolVacio()){
			EnOrdenDescendente(arbol.HijoDer(), cola); 
			cola.Acolar(arbol.Raiz());
			EnOrdenDescendente(arbol.HijoIzq(), cola);
		}
	}
	
	private void EnOrdenAscendente(ABBTDA arbol, ColaTDA cola) {
		if (!arbol.ArbolVacio()){
			EnOrdenAscendente(arbol.HijoIzq(), cola); 
			cola.Acolar(arbol.Raiz());
			EnOrdenAscendente(arbol.HijoDer(), cola);
		}
	}
	
	private void CopiarConjunto(ConjuntoLD original, ConjuntoTDA copia) {
		ColaLD aux = new ColaLD();
		aux.InicializarCola();
		int extra;
		
		while (!original.ConjuntoVacio()) {
			extra = original.Elegir();
			aux.Acolar(extra);
			original.Sacar(extra);
		}
		
		while (!aux.ColaVacia()) {
			extra = aux.Primero();
			aux.Desacolar();
			original.Agregar(extra);
			copia.Agregar(extra);
		}
	}

	public void Claves (int parametro) {
		ColaTDA cola = new ColaLD();
		cola.InicializarCola();
		
		ABBTDA c = new ABB();
		c.InicializarArbol();
		
		NodoClave aux = origen; 
		while (aux != null){
			c.AgregarElem(aux.clave);
			aux = aux.sigClave; 
		}
		
		if (parametro == 1) {
			EnOrdenAscendente(c, cola);
			 
		}else if (parametro == 2) {
			EnOrdenDescendente(c, cola);
		}
		
		while (!cola.ColaVacia()) {
			System.out.println(cola.Primero());
			cola.Desacolar();
		}
	}

}
