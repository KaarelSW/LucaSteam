/**
 * 
 * @author Grupo02
 * 
 *Nombre: Menu
 *
 *Descripcion: En esta clase se indica lo que se mostrar� en pantalla mientras se espera que el usuario 
 *elija una opcion introduciendo uno de los numeros indicados.
 *
 *Fecha: 04/03/22
 *
 *Version: 1
 *
 *Nueva opcion para indicar que se pulse el 4? para mostrar las distribuidoras
 *
 *Fecha: 07/03/22
 *
 *Version: 1
 *
 */

package gui;

public class Menu {

	public void mostrarMenu(){
		System.out.println("");
		System.out.println(" Menú principal  ");
		System.out.println("");
		System.out.println("***************************");
		System.out.println("Seleccione una opción: ");
		System.out.println("	1. Listar juegos ");
		System.out.println("	2. Filtrar los juegos de Nintendo ");
		System.out.println("	3. A�adir juego ");
		System.out.println("	4. Listar distribuidoras ");
		System.out.println("	0. Salir ");	
		System.out.println("***************************");
		System.out.println(">> ");	
	}
	
}
