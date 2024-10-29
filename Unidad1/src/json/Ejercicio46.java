package json;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Ejercicio46 {

	public static void main(String[] args) {
		
		ObjectMapper mapper = new ObjectMapper();
        
        try {
            // Leer el JSON y mapearlo directamente a un objeto Recetas
            Recetas recetas = mapper.readValue(new File("ej46recetas.json"), Recetas.class);
            
            // Ejemplo: imprimir los nombres de cada receta
            for (Receta receta : recetas.getRecetas()) {
                System.out.println("Receta: " + receta.getNombre());
                System.out.println("Tipo: " + receta.getTipo());
                System.out.println("Origen: " + receta.getOrigen().getPais() + ", " + receta.getOrigen().getRegion());
                System.out.println("Ingredientes: ");
                for(Ingrediente i : receta.getIngredientes()) {
                	System.out.println("- " + i.getNombre() + ": " + i.getCantidad());
                }
                System.out.println();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

	}

}
