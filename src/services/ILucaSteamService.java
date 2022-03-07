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
 */

package services;

public interface ILucaSteamService {
	
	public void listarJuegosServicios();
	public void filtrarPlataformaServicios(String empresa);
	

}
