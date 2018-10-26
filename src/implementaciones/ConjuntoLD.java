package implementaciones;

import apis.ConjuntoTDA;

class Nodo{ 
	int info; 
	Nodo sig;
}

public class ConjuntoLD implements ConjuntoTDA {

	Nodo c;
	
	@Override
	public void InicializarConjunto() {
		c = null;
	}

	@Override
	public boolean ConjuntoVacio() {
		return (c == null);
	}

	@Override
	public void Agregar(int x) {
		/* Verifica que x no este en el conjunto */
		if (!this.Pertenece(x)){ 
			Nodo aux = new Nodo(); 
			aux.info = x;
			aux.sig = c;
			c = aux; 
		}
	}

	@Override
	public int Elegir() {
		return c.info;
	}

	@Override
	public void Sacar(int x) {
		if(c!=null){
			// si es el primer elemento de la lista
			if (c.info==x){ 
				c = c.sig;
			}else{
				Nodo aux = c;
			    while (aux.sig!=null && aux.sig.info!=x) 
			    	aux = aux.sig;
			    if (aux.sig != null) 
			    	aux.sig = aux.sig.sig;
			}
		}
	}

	@Override
	public boolean Pertenece(int x) {
		Nodo aux = c;
		while ((aux != null) && (aux.info != x)){ 
			aux = aux.sig;
		}
		return (aux != null);
	}
}
