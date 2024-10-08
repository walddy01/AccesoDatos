package ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejemplo {

	public static void main(String[] args) {
		
		Ejemplo ejemplo = new Ejemplo();
		Scanner teclado = new Scanner(System.in);
		int select = 0;
		
		do {
			System.out.println("-----------------------------------------");
			System.out.println("1. Crear Fichero.");
			System.out.println("2. Comprobar si es fichero o directorio..");
			System.out.println("3. Listar.");
			System.out.println("4. Ejercicio 3.");
			System.out.println("5. Ejercicio 4.");
			System.out.println("6. Ejercicio 5.");
			System.out.println("-----------------------------------------");
			System.out.println("¿Qué método quieres ejecutar?");
			select = teclado.nextInt();
			
			switch (select) {
			case 1:
				ejemplo.crearFichero();
				break;
			case 2:
				ejemplo.comprobarFichero();
				break;
			case 3:
				ejemplo.listar();
				break;
			case 4:
				ejemplo.ejercicio3();	
				break;
			case 5:
				ejemplo.ejercicio4();	
				break;
			case 6:
				ejemplo.ejercicio5();	
				break;
			default:
				if (select != 0) {
					select = 0;
				}
				break;
			}
			
		} while (select == 0);


		
		///home/diurno/eclipse-workspace/Unidad1/
	}
	
	public void crearFichero () {
		File fichero = new File("ejemplo.txt");
		
		
		try {
			
			if (fichero.exists()) {
				System.out.println("Ese fichero ya existe.");
				System.out.println(fichero.getAbsolutePath());
			} else {
				fichero.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		}			
	}

	public void comprobarFichero() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce una ruta: ");
		String ruta = teclado.nextLine();
		
		try {
			File fichero = new File(ruta);
			
			if (fichero.isFile()) {
				System.out.println("Es un fichero.");
			} else if (fichero.isDirectory()){
				System.out.println("Es un directorio.");
			} else {
				System.out.println("La ruta no es valida.");
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		} finally {
			teclado.close();
		}
	}
	
	public void listar() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce una ruta: ");
		String ruta = teclado.nextLine();
		
		try {
			File fichero = new File(ruta);
			
			File[] lista = fichero.listFiles();
			
			for (File i: lista) {
				System.out.println("Nombre: " + i.getName());
				System.out.println("Es fichero: " + i.isFile());
				System.out.println("Es directorio: " + i.isDirectory() + "\n");
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		} finally {
			teclado.close();
		}
	}

	public void ejercicio3() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce una ruta: ");
		String ruta = teclado.nextLine();
		
		try {
			File fichero = new File(ruta);
			
			File[] lista = fichero.listFiles();
			
			if (fichero.exists() && fichero.isDirectory()) {
				System.out.println("Contenido de " + ruta);
				
				for (File i: lista) {
					System.out.println("Nombre: " + i.getName());
					System.out.print("Permisos: ");
					if (i.canRead()) {
						System.out.print("r");
					}
					if (i.canWrite()) {
						System.out.print("w");
					}
					if (i.canExecute()) {
						System.out.print("x");
					}
					System.out.println("\n");
				}
			} else {
				System.out.println("No es un directorio.");
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		} finally {
			teclado.close();
		}
	}

	public void ejercicio4() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce el nombre la carpeta: ");
		String nombre = teclado.nextLine();
		
		try {
			
			File fichero = new File(nombre);
			
			if (!fichero.exists()) {
				
				fichero.mkdir();
				
				System.out.println("Carpeta creada correctamente.");
				
			} else {
				System.out.println("Ya existe una carpeta con ese nombre.");
			}
			
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		} finally {
			teclado.close();
		}
	}

	public void ejercicio5() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce el nombre del archivo: ");
		String nombre = teclado.nextLine();
		
		try {
			
			File fichero = new File(nombre);
			if (!fichero.exists()) {
				fichero.createNewFile();
				System.out.println("Fichero " + nombre + " creado con éxito.");
			} else {
				System.out.println("Ya existe un fichero con ese nombre.");
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		} finally {
			teclado.close();
		}
	}

	public void ejercicio6() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce la ruta del fichero a renombrar: ");
		String original = teclado.nextLine();
		
		try {
			File fichero = new File(original);
			
			if (fichero.exists()) {
				
			}
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error: " + e.getMessage());
		}
	}
}
