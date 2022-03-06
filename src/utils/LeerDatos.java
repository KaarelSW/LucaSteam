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

}
