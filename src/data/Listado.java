/**
 * 
 * @author Grupo02
 * 
 *Nombre: Listado
 *
 *Descripcion: En esta clase se guarda la lista de Juegos, asi como los metodos para leer el archivo CSV y
 *crear los Juegos que iran a la listaJuegos a partir de los datos de dicho archivo y el metodo para 
 *mostrar la listaJuegos en pantalla.
 *
 *Fecha: 06/03/22
 *
 *Version: 2
 *Version 2.1 
 *
 *Nuevo metodo para mostrar las distribuidoras de los juegos en la lista. Devuelve un array con las distribuidoras 
 *y las muestra por pantalla.
 *
 *Fecha: 07/03/22
 *
 *Version: 3
 *
 */

package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import model.Genero;
import model.Juego;
import model.Plataforma;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public @Data class Listado implements IListado {

	// Declaramos un Mapa para almacenar
	// la lista de juegos

	private Map<Integer, Juego> listaJuegos;

	public Listado() {

		listaJuegos = new HashMap<>();
	}

	// Creamos un metodo para recorrer el el mapa

	public void mostrarJuegos(){
			
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			System.out.println(entrada.toString());
		}
	}

	public boolean cargarCSV(String url) {
		
		listaJuegos = new HashMap<>();
		int id = 0;
		try (BufferedReader lector = new BufferedReader(new FileReader(url))) {
			String line = lector.readLine();
			while (line != null) {
				if(id != 0) {
				String[] atributos = line.split("	");
				Juego juego = crearJuego(atributos);
				listaJuegos.put(id, juego);
				}
				id++;
				line = lector.readLine();
			}
			return true;
		} catch (IOException error) {
			error.printStackTrace();
		}
		return false;
	}

	public Juego crearJuego(String[] atributos) {
		
		String nombre = atributos[1];
		Plataforma plataforma;
		if(atributos[2].equals("3DS")) {
			plataforma = Plataforma.valueOf("N3DS");
		} else if (atributos[2].equals("2600")) {
			plataforma = Plataforma.valueOf("DOSMILSEISCIENTOS");
		}else if (atributos[2].equals("3DO")) {
			plataforma = Plataforma.valueOf("TRESDO");
		} else {
			plataforma = Plataforma.valueOf(atributos[2].toUpperCase());
		}	
		int fechaPublicacion = 0;
		if(atributos[3].equals("N/A")) {
			fechaPublicacion = -1;
		}else {
			fechaPublicacion = Integer.parseInt(atributos[3]);
		}			
		Genero genero;
		if(atributos[4].equals("Role-Playing")) {
			genero = Genero.valueOf("ROLEPLAYING");
		}else {
			genero = Genero.valueOf(atributos[4].toUpperCase());
		}
		String distribuidora = atributos[5];
		return new Juego(nombre, plataforma, fechaPublicacion, genero, distribuidora);
	}
	
	public void filtrarJuegosPlataforma(String empresa){
		
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			if (entrada.getValue().getPlataforma().getEmpresa() == empresa) {
				System.out.println(entrada.toString());
			}
		}
	}

	public void darDeAltaJuego(String[] atributos) {
		
		Juego juegoEnAlta=crearJuego(atributos);
		listaJuegos.put(listaJuegos.size()+1, juegoEnAlta);
	}
	

	//Creamos un metodo para filtrar por el genero plataforma
	@Override
	public void filtrarGenero(String plataforma){
		
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			if (entrada.getValue().getGenero().equals(Genero.PLATFORM)) {
				System.out.println(entrada.toString());
			}
		}
	}

	public ArrayList<String> mostrarDistribuidoras(){
		
		ArrayList<String> distribuidoras = new ArrayList<String>();
		String editor = "";
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			if (distribuidoras.contains(entrada.getValue().getDistribuidora())) {
				continue;
			}else {
				editor = entrada.getValue().getDistribuidora();
				distribuidoras.add(editor);
				System.out.println(editor);
			}
		}
		return distribuidoras;
	}
	
	public void filtrarSigloXX(){
		
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			if ((entrada.getValue().getFechaPublicacion()>=1901)&&(entrada.getValue().getFechaPublicacion()<=2000)) {
				System.out.println(entrada.toString());
			}
		}
	}
	

}