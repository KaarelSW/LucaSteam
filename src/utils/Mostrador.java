/**
*
* @author Grupo02
*
*Nombre: Mostrador
*
*Descripcion: Esta clase se usa para generar informes a partir de un ArrayList o de
*un HashSet para mostrarlos por consola.
*
*Fecha: 08/03/22
*Version 1
*
*/

package utils;
import java.util.ArrayList;
import java.util.HashSet;

public class Mostrador {
	
	public static void mostrarInforme(ArrayList<String> info) {
		for (String linea : info) {
			System.out.println(linea);
		}
	}
	
	public static void mostrarInforme(HashSet<String> info) {
		for (String linea : info) {
			System.out.println(linea);
		}
	}

}
