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
 *Fecha: 07/03/22
 *
 *Version: 2
 *
 */

package services;

import data.IListado;
import data.Listado;

public class LucaSteamService implements ILucaSteamService {
	
	private IListado listado = new Listado();

	@Override
	public void listarJuegos() {
		listado.cargarCSV("vgsalesTab.csv"); //A falta de base de datos, hardcodeamos el archivo CSV
        listado.mostrarJuegos();		
    }	
	
	@Override
	public void filtrarPlataformaServicios() {
		listado.filtrarPlataforma();
		
	}

}
