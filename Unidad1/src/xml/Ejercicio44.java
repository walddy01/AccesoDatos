package xml;

import java.util.Scanner;

public class Ejercicio44 {
	
	static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int select = -1;
		
		do {
			System.out.println("1. Ver datos de la empresa.");
			System.out.println("2. Ver trabajadores.");
			System.out.println("3. Añadir trabajadores.");
			System.out.println("4. Modificar trabajador.");
			System.out.println("5. Borrar trabajador.");
			System.out.println("6. Salir.");
			select = Integer.parseInt(teclado.nextLine());
			
			switch (select) {
			case 1:
				
				break;
			case 2:
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			default:
				if (select != 6) {
					select = -1;
					System.out.println("Opción no valida.");
				}
				break;
			}
		} while (select != 6);

	}

}
