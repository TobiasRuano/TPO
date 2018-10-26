package apis;

public interface DiccionarioMultipleTDA { void InicializarDiccionario();

	void Agregar(int clave, int valor);
	
	void Eliminar(int clave);
	
	void EliminarValor(int clave, int valor);
	
	void Recuperar(int clave, int parametro);
	
	void Claves(int parametro); 
}
