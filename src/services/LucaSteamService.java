/**
 * 
 * @author Grupo02
 * 
 *Nombre: LucaSteamService
 *
 *Descripci�n: Clase del paquete de servicios que se encarga, con el m�todo listarJuegos(), de llamar a los
 *m�todos cargarCSV(String url) y mostrarJuegos() para leer el archivo CSV, guardar los Juegos en la lista
 *y mostrarlos por pantalla.
 *
 *Fecha: 07/03/22
 *
 *Versi�n: 2
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
