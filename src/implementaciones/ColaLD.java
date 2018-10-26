package implementaciones;

import apis.ColaTDA;

public class ColaLD implements ColaTDA {
	
	//Primer elemento en la cola
	Nodo primero;
	//́Ultimo elemento en la cola, es decir, el ultimo agregado
	Nodo ultimo;

	@Override
	public void InicializarCola() {
		primero = null;
		ultimo = null;
	}

	@Override
	public void Desacolar() {
		primero = primero.sig;
		// Si la cola queda vacia
		if(primero == null) ultimo = null;
	}

	@Override
	public boolean ColaVacia() {
		return (ultimo == null);
	}

	@Override
	public int Primero() {
		return primero.info;
	}

	@Override
	public void Acolar(int x) {
		Nodo aux = new Nodo(); aux.info = x;
		aux.sig = null;
		//Si la cola no esta vacia
		if(ultimo != null) 
			ultimo.sig = aux;
		
		ultimo = aux;
		
		// Si la cola esta vacia
		if(primero == null) 
			primero = ultimo;
	}

}
