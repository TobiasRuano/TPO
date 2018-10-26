package Pruebas;

import implementaciones.DiccionarioMultiple;


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
		
	
		System.out.println("Muestro los valores de la clave 7\n");
		DM.Recuperar(7, 2);
		System.out.println("\nMuestro todas las claves\n");
		DM.Claves(2);
		
	}

}
