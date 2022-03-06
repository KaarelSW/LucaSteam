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
		System.out.println("Adiós locoo");		
	}
	
	public boolean selectorDeOpciones() {
		
		boolean seguir = true;
		
		try {
			switch(LeerDatos.LeerInt()) {
			case 1: 
				servicios.listarJuegos();
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
	
}
