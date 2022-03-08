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
 *Se ha incluido el metodo para dar de alta un juego para sumarlo a la lista (public void darDeAltaJuego(String[] datos))
 *
 *Fecha: 06/03/22
 *
 *Version: 2
 *
 *Añadidos los metodos mostrarDistribuidoras(), filtrarSigloXX(), filtrarPorFechaPar().
 *
 *Fecha: 07/03/22
 *
 *Version: 3
 *
 *Se han incluido los los metodos para modificar un juego y para eliminar un juego, asi como un metodo para
 *buscar juegos.
 *
 *Fecha: 08/03/22
 *
 *Version: 4
 *
 *
 */

package data;

import java.util.ArrayList;
import java.util.HashSet;

import exceptions.LucaSteamExcepciones;
import model.Juego;

public interface IListado {
	
	public ArrayList<String> mostrarJuegos();
	public boolean cargarCSV(String url) throws LucaSteamExcepciones;
	public Juego crearJuego(String[] atributos) throws LucaSteamExcepciones;
	public ArrayList<String> filtrarJuegosPlataforma(String empresa);
	public void darDeAltaJuego(String[] datos) throws LucaSteamExcepciones;
	public ArrayList<String> filtrarGenero(String genero);
	public HashSet<String> mostrarDistribuidoras();
	public ArrayList<String> filtrarSigloXX();
	public ArrayList<String> filtrarPorFechaPar();
	public int buscarJuego(String nombre) throws LucaSteamExcepciones;
	public String eliminarJuego(String nombre) throws LucaSteamExcepciones;
	public String modJuego(String nombre) throws LucaSteamExcepciones;
}
