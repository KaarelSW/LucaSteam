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
 *Fecha: 06/03/22
 *
 *Version: 2
 *Version 2.1 Añadido el metodo filtrarPlataformaServicios
 *
 *Ahora cargarCSV se llama de forma separada y tambien se ha creado el metodo darAltaJuegosServicios para 
 *llamar tanto a solicitarDatos() como a darDeAltaJuego(datos) de listado.
 *
 *Fecha: 07/03/22
 *
 *Version: 3
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
	
	// En este metodo hacemos la llamado a la capa de Datos
	
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
	
	public void filtrarSigloXX() {
		Mostrador.mostrarInforme(listado.filtrarSigloXX());
	}
	
	public void filtrarPorParServicios() {
		Mostrador.mostrarInforme(listado.filtrarPorFechaPar());
	}
	

}
