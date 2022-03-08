/**
 * 
 * @author Grupo02
 * 
 *Nombre: LeerDatos
 *
 *Descripcion: Clase utilizada para la lectura de datos introducidos por teclado llamando a la clase Scanner
 *
 *Fecha: 04/03/22
 *
 *Version: 1
 *
 */

package utils;

import java.util.Scanner;

public class LeerDatos {
	
	public static int LeerInt() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	public static int LeerInt(String msg) {
		System.out.println(msg);
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	
	public static String LeerTexto(String msg) {
		System.out.println(msg);
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public static String[] solicitarDatos() {
		
		String atributos[] = new String[6];
		
		atributos[1] = LeerTexto("Introduzca el nombre del juego");
		atributos[2] = LeerTexto("Introduzca su plataforma");
		atributos[3] = LeerTexto("Introduzca el año de salida de " + atributos[1]);
		atributos[4] = LeerTexto("A que género pertenece?");
		atributos[5] = LeerTexto("Por último, indique la distribuidora");
		
		return atributos;
	}

	public static String solicitarNombre() {
		return LeerTexto("Introduzca el nombre del juego");
	}

}
