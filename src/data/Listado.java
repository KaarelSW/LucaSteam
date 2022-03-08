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
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

import exceptions.LucaSteamExcepciones;
import lombok.Data;
import model.Genero;
import model.Juego;
import model.Plataforma;
import utils.LeerDatos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public @Data class Listado implements IListado {

	// Declaramos un Mapa para almacenar
	// la lista de juegos

	private Map<Integer, Juego> listaJuegos;

	public Listado() {

		listaJuegos = new HashMap<>();
	}

	// Creamos un metodo para recorrer el el mapa

	public ArrayList<String> mostrarJuegos(){
			
		ArrayList<String> juegosTotales = new ArrayList<String>();
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			juegosTotales.add(entrada.toString());
		}
		return juegosTotales;
	}

	public boolean cargarCSV(String url) throws LucaSteamExcepciones {
		
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
			if (listaJuegos.size()==0) {
				throw new LucaSteamExcepciones("El csv está vacío",1);
			}
			return true;
		} catch (IOException error) {
			error.printStackTrace();
		}
		return false;
	}

	public Juego crearJuego(String[] atributos) throws LucaSteamExcepciones {
		
		if (atributos[1] == "" || atributos[2] == "" || atributos[3] == "" || atributos[4] == "" || atributos[5] == "" ) throw new LucaSteamExcepciones("Existe uno o varios campos vacíos", 2);
		String nombre = atributos[1];
		Plataforma plataforma;
		if(atributos[2].equals("3DS")) {
			plataforma = Plataforma.valueOf("N3DS");
		} else if (atributos[2].equals("2600")) {
			plataforma = Plataforma.valueOf("DOSMILSEISCIENTOS");
		}else if (atributos[2].equals("3DO")) {
			plataforma = Plataforma.valueOf("TRESDO");
		} else {			
			try {
				plataforma = Plataforma.valueOf(atributos[2].toUpperCase());
			}catch(IllegalArgumentException error) {
				throw new LucaSteamExcepciones("Plataforma inválido: no es una de las plataformas contempladas", 2);
			}
		}	
		int fechaPublicacion = 0;
		if(atributos[3].equals("N/A")) {
			fechaPublicacion = -1;
		}else {
			int fechaParseada = Integer.parseInt(atributos[3]);
			if (fechaParseada < 1958) throw new LucaSteamExcepciones("Fecha incorrecta: año anterior a la fecha del primer videojuego", 2);
			else fechaPublicacion = fechaParseada;
		}			
		Genero genero;
		if(atributos[4].equals("Role-Playing")) {
			genero = Genero.valueOf("ROLEPLAYING");
		}else {
			try {
				genero = Genero.valueOf(atributos[4].toUpperCase());
			}catch(IllegalArgumentException error) {
				throw new LucaSteamExcepciones("Género inválido: no es uno de los géneros contemplados", 2);
			}
		}	
		String distribuidora = atributos[5];
		return new Juego(nombre, plataforma, fechaPublicacion, genero, distribuidora);
	}
	
	public ArrayList<String> filtrarJuegosPlataforma(String empresa){
		
		ArrayList<String> juegosFiltrados = new ArrayList<String>();
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			
			if (entrada.getValue().getPlataforma().getEmpresa() == empresa) {
				juegosFiltrados.add(entrada.toString());
			}
		}
		return juegosFiltrados;
	}

	public void darDeAltaJuego(String[] atributos) throws LucaSteamExcepciones {
		
		Juego juegoEnAlta=crearJuego(atributos);
		listaJuegos.put(listaJuegos.size()+1, juegoEnAlta);
		int fecha = LocalDate.now().getYear();
		if(Integer.parseInt(atributos[3]) > fecha) throw new LucaSteamExcepciones("Early Access: Este juego no ha salido aún.", 3);
	}
	

	//Creamos un metodo para filtrar por el genero plataforma

	public ArrayList<String> filtrarGenero(String genero){
		
		ArrayList<String> juegosFiltrados = new ArrayList<String>();
		try {
			for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
				
				if (entrada.getValue().getGenero().equals(Genero.valueOf(genero.toUpperCase()))) {
					juegosFiltrados.add(entrada.toString());
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return juegosFiltrados;
	}

	public HashSet<String> mostrarDistribuidoras(){
		
		HashSet<String> distribuidoras = new HashSet<String>();
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
				distribuidoras.add(entrada.getValue().getDistribuidora());
		}
		return distribuidoras;
	}
	
	public ArrayList<String> filtrarSigloXX(){
		
		ArrayList<String> juegosFiltrados = new ArrayList<String>();
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			if ((entrada.getValue().getFechaPublicacion()>=1901)&&(entrada.getValue().getFechaPublicacion()<=2000)) {
				juegosFiltrados.add(entrada.toString());
			}
		}
		return juegosFiltrados;
	}
	
	public String eliminarJuego(String nombre) throws LucaSteamExcepciones {
		
		try {
			int codigoJuegoAEliminar = buscarJuego(nombre);
			String juegoEliminado = listaJuegos.get(codigoJuegoAEliminar).getNombre();
			listaJuegos.remove(codigoJuegoAEliminar);
			return juegoEliminado;
		} catch (LucaSteamExcepciones e) {
			e.printStackTrace();			
		}
		return "";
	}
	/*
	public void buscarJuego(String nombre) {
	
		Map<Integer, String> resultadoBusqueda = new HashMap<Integer,String>();
		for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			if(entrada.getValue().getNombre().contains(nombre)) {
				resultadoBusqueda.put(entrada.getKey(), entrada.getValue().getNombre());
			}
		}
	}*/
	
	public int buscarJuego(String nombre) throws LucaSteamExcepciones {
		Map<Integer, String> resultadoBusqueda = listaJuegos.entrySet().stream()
				.filter(x -> x.getValue().getNombre().toUpperCase().contains(nombre.toUpperCase()))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue().getNombre()));
		if(resultadoBusqueda.size() == 0) {
			throw new LucaSteamExcepciones("Búsqueda sin resultados", 2);
		}else if(resultadoBusqueda.size() == 1) {
			return resultadoBusqueda.entrySet().iterator().next().getKey();
		}else {
			resultadoBusqueda.entrySet().stream().forEach(x -> System.out.println("Código: "+ x.getKey()+ " = "+x.getValue()));
			System.out.println("");
			int resultado;
			do
				resultado = LeerDatos.LeerInt("Introduzca el código del juego seleccionado: ");	
			while(!resultadoBusqueda.containsKey(resultado)); 
			return resultado;		
		}	
	}

}