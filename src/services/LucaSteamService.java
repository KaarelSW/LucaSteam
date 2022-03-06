/**
 * 
 * @author Grupo02
 * 
 *Nombre: LucaSteamService
 *
 *Descripción: Clase del paquete de servicios que se encarga, con el método listarJuegos(), de llamar a los
 *métodos cargarCSV(String url) y mostrarJuegos() para leer el archivo CSV, guardar los Juegos en la lista
 *y mostrarlos por pantalla.
 *
 *Fecha: 07/03/22
 *
 *Versión: 2
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

}
