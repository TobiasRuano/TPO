package apis;

public interface DiccionarioMultipleTDA { void InicializarDiccionario();

	void Agregar(int clave, int valor);
	
	void Eliminar(int clave);
	
	void EliminarValor(int clave, int valor);
	
	ABBTDA Recuperar(int clave);
	
	ABBTDA Claves(); 
}
