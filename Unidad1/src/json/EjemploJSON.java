package json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class EjemploJSON {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		
		//LEER una cadena json
		String jsonInput =	
		"{\"id\":1,\"nombre\":\"Robin\",\"apellido\":\"Wilson\"}";
		Animados a=new Animados();
		try {
		a = mapper.readValue(jsonInput, Animados.class);
		} catch (JsonProcessingException e) {
		e.printStackTrace();
		}
		
		try {
			mapper.writeValue(new File("personaSalida.json"), a);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Leer y parsed a animados desde JSON: " + a);
		
		//ESCRIBE una cadena json
		Animados b = new Animados(2,"Roger", "Rabbit");
		System.out.print("Animado object " + b + " as JSON = ");
		try {
		mapper.writeValue(System.out, b);
		} catch (IOException e) {
		e.printStackTrace();
		 }
		}
}
