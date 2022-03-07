/**
 * 
 * @author Grupo02
 * 
 *Nombre: LucaSteam
 *
 *Descripcion: Esta clase llama a la capa de servicios una vez se ha elegido una de las opciones que se
 *muestran en pantalla. De momento las opciones son mostrar la lista de juegos o salir.
 *
 *Fecha: 04/03/22
 *
 *Version: 1
 *
 */

package control;

import gui.Menu;
import services.ILucaSteamService;
import services.LucaSteamService;
import utils.LeerDatos;


public class LucaSteam {
	
	private ILucaSteamService servicios = new LucaSteamService();	
	
	public void abrirMenu() {
		
		boolean seguir = true;
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
				servicios.listarJuegos();
				break;
			case 3: 
				String[] array = solicitarDatos();
				//servicios.darDeAltaJuegos();
				break;
			case 0:
				// Salir
				seguir = false;
			}
		} catch ( Exception e ) {
			System.out.println("Error " + e.toString());
		}		
		return seguir;		
	}	
	
	public String[] solicitarDatos() {
		
		String atributos[] = new String[5];
		LeerDatos entrada = new LeerDatos();
		
		atributos[0] = entrada.LeerTexto("Introduzca el nombre del juego");
		atributos[1] = entrada.LeerTexto("Introduzca su plataforma");
		atributos[2] = entrada.LeerTexto("Introduzca el año de salida de " + atributos[0]);
		atributos[3] = entrada.LeerTexto("¿A qué género pertenece?");
		atributos[4] = entrada.LeerTexto("Por último, indique la distribuidora");
		
		return atributos;
	}
	
}
