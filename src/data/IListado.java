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
import java.util.HashSet;
import model.Juego;

public interface IListado {
	
	public ArrayList<String> mostrarJuegos();
	public boolean cargarCSV(String url);
	public Juego crearJuego(String[] atributos);
	public ArrayList<String> filtrarJuegosPlataforma(String empresa);
	public void darDeAltaJuego(String[] datos);
	public ArrayList<String> filtrarGenero(String genero);
	public HashSet<String> mostrarDistribuidoras();
	public ArrayList<String> filtrarSigloXX();

}
