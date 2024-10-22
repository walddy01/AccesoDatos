package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio33 {

    public static void main(String[] args) {
        try {
            // Crear un nuevo objeto DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Cargar el archivo XML
            File archivoXML = new File("ej33catalogo.xml");
            Document documento = builder.parse(archivoXML);
            // Normalizar el documento para eliminar espacios vacíos
            documento.getDocumentElement().normalize();
            // Obtener el elemento raíz
            Element raiz = documento.getDocumentElement();
            // Mostrar los nodos recursivamente
            recorrerRamaDom(raiz, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Método para recorrer recursivamente el DOM
    public static void recorrerRamaDom(Node nodo, int nivel) {
        // Comprobar si el nodo es de tipo ELEMENT_NODE
        if (nodo != null && nodo.getNodeType() == Node.ELEMENT_NODE) {
            // Crear indentación en función del nivel del nodo
            String indentacion = " ".repeat(nivel * 4); // Cada nivel añade 4 espacios
            // Mostrar el nombre del nodo
            System.out.println(indentacion + "Elemento: " + nodo.getNodeName());

            // Mostrar los atributos si existen
            if (nodo.hasAttributes()) {
                NamedNodeMap atributos = nodo.getAttributes();
                for (int i = 0; i < atributos.getLength(); i++) {
                    Node atributo = atributos.item(i);
                    System.out.println(indentacion + "  Atributo: " + atributo.getNodeName() + " = " + atributo.getNodeValue());
                }
            }

            // Obtener los hijos del nodo
            NodeList hijos = nodo.getChildNodes();
            // Recorrer los nodos hijos
            for (int i = 0; i < hijos.getLength(); i++) {
                Node hijo = hijos.item(i);

                // Si es un nodo de texto, mostrar el valor
                if (hijo.getNodeType() == Node.TEXT_NODE && hijo.getNodeValue().trim().length() > 0) {
                    System.out.println(indentacion + "  Valor: " + hijo.getNodeValue().trim());
                }
                // Si es un elemento, llamar recursivamente
                else if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                    recorrerRamaDom(hijo, nivel + 1); // Llamada recursiva con un nivel más
                }
            }
        }
    }
}
