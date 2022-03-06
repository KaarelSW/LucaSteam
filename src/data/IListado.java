/**
 * 
 * @author Grupo02
 * 
 *Nombre: IListado
 *
 *Descripción: Interfaz de la clase Listado, se declaran los métodos de la clase Listado para que sean
 *sobreescritos por esta.
 *
 *Fecha: 04/03/22
 *
 *Versión: 1
 *
 */

package data;

import model.Juego;

public interface IListado {
	
	public void mostrarJuegos();
	public void cargarCSV(String url);
	public Juego crearJuego(String[] atributos);

}
