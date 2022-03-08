/**
 * 
 * @author Grupo02
 * 
 *Nombre: LucaSteamService
 *
 *Descripcion: Clase del paquete de servicios que se encarga, con el metodo listarJuegos(), de llamar a los
 *metodos cargarCSV(String url) y mostrarJuegos() para leer el archivo CSV, guardar los Juegos en la lista
 *y mostrarlos por pantalla.
 *
 *Fecha: 04/03/22
 *
 *Añadido el metodo filtrarPlataformaServicios
 *
 *Fecha: 06/03/22
 *Version: 2
 *
 *Ahora cargarCSV se llama de forma separada y tambien se ha creado el metodo darAltaJuegosServicios para 
 *llamar tanto a solicitarDatos() como a darDeAltaJuego(datos) de listado.
 *
 *Fecha: 07/03/22
 *Version: 3 
 *
 *  Se añaden los siguientes metodos:
 *  - mostrarDistribuidorasServicios(), que es llamado por la clase LucaSteam y llama
 *    a Mostrador.mostrarInforme. 
 *    
 *  - filtrarGeneroServicios(), que es llamado por la clase LucaSteam y llama
 *    a Mostrador.mostrarInforme. 
 *    
 *  - filtrarSigloXXServicios(), que es llamado por la clase LucaSteam y llama
 *    a Mostrador.mostrarInforme. 
 *    
 *  - eliminarJuegoServicios(), que es llamado por la clase LucaSteam y llama
 *    a Listado.eliminarJuego()
 *    
 *  - modJuegoServicios, que es llamado por la clase LucaSteam y llama
 *    a Listado.modJuego()
 *    
 *  - public void filtrarPorParServicios(), que es llamado por la clase LucaSteam y llama
 *    a Listado.filtrarPorPar()
 *
 *
 */

package services;

import data.IListado;
import data.Listado;
import exceptions.LucaSteamExcepciones;
import utils.Mostrador;

public class LucaSteamService implements ILucaSteamService {
	
	private IListado listado = new Listado();
	
	@Override
	public void cargarCSVServicios() throws LucaSteamExcepciones {
			listado.cargarCSV("vgsalesTab.csv");	
    }	

	@Override
	public void mostrarJuegosServicios() {
		Mostrador.mostrarInforme(listado.mostrarJuegos());		
    }	
	
	@Override
	public void filtrarPlataformaServicios(String empresa) {
		
		Mostrador.mostrarInforme(listado.filtrarJuegosPlataforma(empresa));
	}

	@Override
	public void darDeAltaJuegoServicios(String[] datos) throws LucaSteamExcepciones {
		listado.darDeAltaJuego(datos);	
    }

	@Override
	public void mostrarDistribuidorasServicios() {
		Mostrador.mostrarInforme(listado.mostrarDistribuidoras());
		
	}	
	
	@Override
	public void filtrarGeneroServicios(String genero) {
		Mostrador.mostrarInforme(listado.filtrarGenero(genero));
	}
	
	public void filtrarSigloXXServicios() {
		Mostrador.mostrarInforme(listado.filtrarSigloXX());
	}

	@Override
	public void eliminarJuegoServicios(String nombre) throws LucaSteamExcepciones {
		String juegoEliminado = listado.eliminarJuego(nombre);
		if (juegoEliminado.length() != 0) {
			System.out.println("Juego elimindado: " + juegoEliminado);
		}
	}

	@Override
	public void modJuegoServicios(String nombre) throws LucaSteamExcepciones {
		System.out.println("Datos del juego modificado: " + listado.modJuego(nombre));
	}
	
	@Override
	public void filtrarPorParServicios() {
		Mostrador.mostrarInforme(listado.filtrarPorFechaPar());
	}
	

}
