/**
 * 
 * @author Grupo02
 * 
 *Nombre: Juego
 *
 *Descripcion: Interfaz de LucaSteamService en la que se declaran sus metodos para que se sobreescriban en
 *esta.
 *
 *Fecha: 04/03/22
 *
 *Version: 1
 *
 *Nuevo metodo darDeAltaJuegosServicios() 
 *
 *Fecha: 07/03/22
 *
 *Version: 2
 *
 */

package services;

public interface ILucaSteamService {
	
	public void cargarCSVServicios();
	public void mostrarJuegosServicios();
	public void darDeAltaJuegoServicios(String[] datos);

}
