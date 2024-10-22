package flujos;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

	public class Ejercicio32Aleatorio2 {
	
		static Scanner teclado = new Scanner(System.in);
		static RandomAccessFile archivo;
		
	    public static void main(String[] args) {
	    	
	    	try {
	    		archivo = new RandomAccessFile("productos.dat", "rw");
	    		
	    		//Escribimos 3 productos
	    		escribirProducto(archivo, 1, "Leche", 1.50, 100);
	    		escribirProducto(archivo, 2, "Pan", 1.75, 200);
	    		escribirProducto(archivo, 3, "Galletas", 5.30, 50);
	    		
	    		//Leemos el producto 1
	    		leerProducto(archivo, 1);
	    		
	    	} catch (FileNotFoundException e) {
	    		e.printStackTrace();
	    	}
	    	
	    	int opcion = 0;
	    	
	    	while(opcion!=5) {
	    		System.out.println("Elige una opción:");
	    		System.out.println("1. Dar de alta un producto.");
	    		System.out.println("2. Mostrar todos los productos.");
	    		System.out.println("3. Modificar el stock de un producto.");
	    		System.out.println("4. Borrar producto.");
	    		System.out.println("5. Salir.");
	    		opcion = Integer.parseInt(teclado.nextLine());
	    		
	    		switch (opcion) {
				case 1:
					altaProducto();
					
					break;
				case 2:
					listarProductos();
					break;
				case 3:
					modificarStock();
					break;
				case 4:
					borrarProducto();
					break;

				default:
					break;
				}
	    	}
	    	
	    }
		private static void escribirProducto(RandomAccessFile archivo, int c, String n, double p, int s) { 
		    // Para leer el nombre del producto ocupe los 20 caracteres
		    if (n.length() < 20) {
		           while (n.length() < 20) {
		            n += " ";  // Si es más corto, añadimos espacios al final
		        }
		    }
            
            // Escribir los datos en el archivo binario
            try {
				archivo.writeInt(c);		// Código 
			    archivo.writeBytes(n); 		// Nombre	//writeBytes cada caracter no Unicode ocupa 1 byte
			  //  archivo.writeChars(n);	            //writeChars array de caracteres
			  //  archivo.writeUTF(n);                  //cada caracter ocupa 2 byte, pero utiliza los 2 bytes primero para indicar la longitud
		        archivo.writeDouble(p);   	// Precio del producto
		        archivo.writeInt(s);     	// Cantidad en stock

		        
            } catch (IOException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			} 
		}     
            
        private static void leerProducto(RandomAccessFile archivo, int indice)  {
        	try {
        	// Mover el puntero del archivo a la posición correspondiente del registro
        	archivo.seek(indice * 36);
            
            // Leer el código
	        int codigo = archivo.readInt();
            
            // Leer el nombre

            byte[] nombreBytes = new byte[20]; 			//creamos temporalmente un array de x bytes
            archivo.read(nombreBytes);					//leemos ese array de byte
            String nombre = new String(nombreBytes); 	//Convertimos el array de byte a String
            nombre.trim();                        		//Quitar los espacios en blanco
            
            // Leer el precio
            double precio = archivo.readDouble();
            // Leer la cantidad en stock
            int cantidad = archivo.readInt();
            // Mostrar los datos leídos
            System.out.println("Código: " + codigo);
            System.out.println("Nombre: " + nombre);
            System.out.println("Precio: " + precio);
            System.out.println("Cantidad en stock: " + cantidad);
        	} catch (EOFException e) {
				e.printStackTrace();
        	} catch (IOException e) {
				e.printStackTrace();
			}
        	
        }

        private static void altaProducto() {
        	try {
				archivo.seek(archivo.length());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.print("Introduce el Código del producto: ");
        	int codigo = Integer.parseInt(teclado.nextLine());
        	System.out.print("Introduce el nombre del producto: ");
        	String nombre = teclado.nextLine();
        	System.out.print("Introduce el Precio del producto: ");
        	double precio = Double.parseDouble(teclado.nextLine());
        	System.out.print("Introduce el Stock del producto: ");
        	int cantidad = Integer.parseInt(teclado.nextLine());
        	
        	escribirProducto(archivo, codigo, nombre, precio, cantidad);
        }
        
        private static void listarProductos() {
        	try {
                archivo.seek(0);

                while (true) {
                    try {
                    	
                        int codigo = archivo.readInt();
                        
                        byte[] nombreBytes = new byte[20];
                        archivo.read(nombreBytes);
                        String nombre = new String(nombreBytes);
                        nombre.trim();

                        double precio = archivo.readDouble();

                        int cantidad = archivo.readInt();

                        System.out.println("Código: " + codigo);
                        System.out.println("Nombre: " + nombre);
                        System.out.println("Precio: " + precio);
                        System.out.println("Cantidad en stock: " + cantidad);
                        System.out.println("--------------------------------");

                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        private static void modificarStock() {
        	boolean encontrado = false;
        	
        	System.out.println("Introduce el ID del producto a modificar: ");
        	int id = Integer.parseInt(teclado.nextLine());
        	
        	try {
				archivo.seek(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	while(true) {
        		try {
        			
					int codigo = archivo.readInt();
					if (codigo != id) {
						archivo.skipBytes(32);
					} else {
						archivo.skipBytes(28);
						System.out.print("Introduce el nuevo Stock: ");
			        	int cantidad = Integer.parseInt(teclado.nextLine());
			        	
			        	archivo.writeInt(cantidad);
			        	encontrado = true;

			        	break;
					}
				} catch (IOException e) {
					break;
				}
        	}
        	
        	if (!encontrado) {
				System.out.println("No se ha encontrado ningún producto con ese ID.");
			}
        }
        
        private static void borrarProducto() {
        	
        	boolean encontrado = false;
        	System.out.println("Introduce el ID del producto a borrar: ");
        	int id = Integer.parseInt(teclado.nextLine());
        	
        	try {
				archivo.seek(0);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	while(true) {
        		try {
        			
					int codigo = archivo.readInt();
					if (codigo != id) {
						archivo.skipBytes(32);
					} else {
						archivo.seek(archivo.getFilePointer()-4);
			        	archivo.writeInt(-1);
			        	encontrado = true;
			        	break;
					}
				} catch (IOException e) {
					break;
				}
        	}
        	
        	if (!encontrado) {
				System.out.println("No se ha encontrado ningún producto con ese ID.");
			}
        }
}
