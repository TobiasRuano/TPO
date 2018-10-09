package Pruebas;

import implementaciones.DiccionarioMultiple;
import implementaciones.ABB;
import Metodos.metodos;


public class test {

	public static void main(String[] args) {
		DiccionarioMultiple DM = new DiccionarioMultiple();
		DM.InicializarDiccionario();
		DM.Agregar(0, 15);
		DM.Agregar(5, 3);
		DM.Agregar(2, 4);
		DM.Agregar(5, 6);
		DM.Agregar(7, 1);
		DM.Agregar(7, 5);
		DM.Agregar(7, 0);

		ABB a = new ABB();
		a.InicializarArbol();
		
		
		//Muestro las claves en orden
		a = (ABB)DM.Claves();
		System.out.println("Claves en Orden Ascendente");
		metodos.MostrarArbol(a, 1); // Muestro en orden ascendente
		System.out.println("\nClaves en Orden Descendente");
		metodos.MostrarArbol(a, 2); // Muestro en orden desendente
		
		//Muestro los valores de las claves en orden
		a = (ABB)DM.Recuperar(7);
		System.out.println("\nValores de clave en Orden Ascendente");
		metodos.MostrarArbol(a, 1); // Muestro en orden ascendente
		System.out.println("\nValores de clave en Orden Descendente");
		metodos.MostrarArbol(a, 2); // Muestro en orden desendente
	}

}
