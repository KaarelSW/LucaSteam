/**
 * 
 * @author Grupo02
 * 
 *Nombre: IListado
 *
 *Descripcion: Interfaz de la clase Listado, se declaran los metodos de la clase Listado para que sean
 *sobreescritos por esta.
 *
 *Fecha: 04/03/22
 *
 *Version: 1
 *
 *Añadido el metodo mostrarDistribuidoras()
 *
 *Fecha: 07/03/22
 *
 *Version: 2
 *
 *
 */

package data;

import java.util.ArrayList;

import model.Juego;

public interface IListado {
	
	public void mostrarJuegos();
	public boolean cargarCSV(String url);
	public Juego crearJuego(String[] atributos);
	public void filtrarJuegosPlataforma(String empresa);
	public void darDeAltaJuego(String[] datos);
	public ArrayList<String> mostrarDistribuidoras();

}
