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
 **Version 1.1 Añadido el metodo filtrarPlataformaServicios
 *
 *Nuevo metodo darDeAltaJuegosServicios() 
 *
 *Fecha: 07/03/22
 *
 *Version: 2
 *
 */

package services;

import exceptions.LucaSteamExcepciones;

public interface ILucaSteamService {
	
	public void mostrarDistribuidorasServicios();
	public void filtrarPlataformaServicios(String empresa);
	public void cargarCSVServicios() throws LucaSteamExcepciones;
	public void mostrarJuegosServicios();
	public void darDeAltaJuegoServicios(String[] datos) throws LucaSteamExcepciones;
	public void filtrarGeneroServicios(String genero);
	public void filtrarSigloXX();
	public void eliminarJuegoServicios(String nombre) throws LucaSteamExcepciones;
	public void modJuegoServicios(String nombre) throws LucaSteamExcepciones;

}
