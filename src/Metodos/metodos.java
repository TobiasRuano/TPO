package Metodos;

import apis.ABBTDA;

public class metodos {
	
	public static void MostrarArbol(ABBTDA a, int flag) {
		if (flag == 1) {
			metodos.EnOrdenAscendente(a);
		}else if (flag == 2) {
			metodos.EnOrdenDescendente(a);
		}else 
			System.out.println("Opcion incorrecta");
	}

	private static void EnOrdenAscendente(ABBTDA arbol) {
		if (!arbol.ArbolVacio()){
			EnOrdenAscendente(arbol.HijoIzq()); 
			System.out.println(arbol.Raiz()); 
			EnOrdenAscendente(arbol.HijoDer());
		}
	}
	
	private static void EnOrdenDescendente(ABBTDA arbol) {
		if (!arbol.ArbolVacio()){
			EnOrdenDescendente(arbol.HijoDer()); 
			System.out.println(arbol.Raiz()); 
			EnOrdenDescendente(arbol.HijoIzq());
		}
	}

}
