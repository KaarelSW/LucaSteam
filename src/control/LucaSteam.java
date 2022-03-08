/**
 * 
 * @author Grupo02
 * 
 *Nombre: LucaSteam
 *
 *Descripcion: Esta clase llama a la capa de servicios una vez se ha elegido una de las opciones que se
 *muestran en pantalla. De momento las opciones son mostrar la lista de juegos o salir.
 *
 *Ahora las opciones incluyen dar de alta un juego para sumarlo a la lista. Y se cargan los datos al 
 *abrir la aplicacion en lugar de al mostrar la lista de juegos.
 *
 *Fecha: 04/03/22
 *
 *Version: 2
 *
 *Ahora las opciones incluyen dar de alta un juego para sumarlo a la lista. Y se cargan los datos al 
 *abrir la aplicacion en lugar de al mostrar la lista de juegos.
 *
 *Fecha: 07/03/22
 *
 *Version: 3
 *
 *Incluida la opcion de mostrar las distribuidoras de los juegos que hay en la lista.
 *
 *Fecha: 07/03/22
 *
 *Version: 4
 *
 */

package control;

import exceptions.LucaSteamExcepciones;
import gui.Menu;
import services.ILucaSteamService;
import services.LucaSteamService;
import utils.LeerDatos;


public class LucaSteam {
	
	private ILucaSteamService servicios = new LucaSteamService();	
	
	public void abrirMenu() {
		
		boolean seguir = true;
		try {
			servicios.cargarCSVServicios();
		} catch (LucaSteamExcepciones e) {
			System.out.println("Tipo de error " + e.toString());
		}
		do {
			new Menu().mostrarMenu();
			seguir = this.selectorDeOpciones();	
		} while (seguir);
		System.out.println("Hasta luego");		
	}
	
	public boolean selectorDeOpciones() {
		
		boolean seguir = true;
		
		try {
			switch(LeerDatos.LeerInt()) {
			case 1: 
				servicios.mostrarJuegosServicios();
				break;
			case 2:
				servicios.filtrarPlataformaServicios("Nintendo");
				break;
			case 3: 
				String[] array = LeerDatos.solicitarDatos();
				servicios.darDeAltaJuegoServicios(array);
				break;
			case 4:
				servicios.filtrarGeneroServicios("Platform");
				break;
			case 5: 
				servicios.mostrarDistribuidorasServicios();
				break;
			case 6: 
				servicios.filtrarSigloXXServicios();
				break;
			case 7: 				
				servicios.eliminarJuegoServicios(LeerDatos.solicitarNombre());
				break;
			case 8: 				
				servicios.modJuegoServicios(LeerDatos.solicitarNombre());
				break;	
			case 9: 
				servicios.filtrarPorParServicios();
				break;
			case 0:
				// Salir
				seguir = false;
			}
		} catch ( Exception e ) {
			System.out.println("Tipo de error " + e.toString());
		}		
		return seguir;		
	}	
	
}
