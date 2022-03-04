package control;

import gui.Menu;
import utils.LeerDatos;

public class Videojuegos {
	
	LeerDatos entrada = new LeerDatos();

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
			switch(entrada.LeerInt()) {
			case 1: 
				// Listar productos
				// método a implementar
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
