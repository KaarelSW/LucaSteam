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
