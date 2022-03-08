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
 *Nuevas opciones para indicar que se pulse:
 *	- 2 para añadir nuevos juegos
 *	- 5 para mostrar todas las distribuidoras de juegos
 *	- 6 para mostrar un informe de juegos filtrados por género de plataformas
 *	- 7 para mostrar un informe de juegos filtrados por plataformas de Nintendo
 *	- 8 para mostrar un informe de los juegos publicados en el siglo XX
 *
 *Fecha: 07/03/22
 *Version: 2
 *
 *Nuevas opciones para indicar que se pulse:
 *	- 3 para eliminar un juego de la lista
 *	- 4 para modificar los datos de un juego de la lista
 *
 *Fecha: 08/03/22
 *Version: 2
 */

package gui;

public class Menu {

	public void mostrarMenu(){
		
		System.out.println("");
		System.out.println(" Pantalla de opciones ");
		System.out.println("");
		System.out.println("***************************");
		System.out.println("");
		System.out.println("Seleccione una opción: ");
		System.out.println("	1. Listar juegos ");
		System.out.println("	2. Agregar juego ");
		System.out.println("	3. Eliminar juego ");
		System.out.println("	4. Modificar juego ");
		System.out.println("	5. Listar distribuidoras ");
		System.out.println("	6. Filtrar los juegos de plataformas ");
		System.out.println("	7. Filtrar los juegos de Nintendo ");
		System.out.println("	8. Filtrar siglo XX ");
		System.out.println("	9. Filtrar juegos lanzados en año par");		
		System.out.println("	0. Salir ");	
		System.out.println("");
		System.out.println("***************************");
		System.out.println("");
		System.out.println(">> ");	
	}
	
	
}
