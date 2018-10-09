package apis;

public interface ColaTDA {

	void InicializarCola();

	void Desacolar();
	
	boolean ColaVacia();
	
	int Primero();

	void Acolar(int x);
}
