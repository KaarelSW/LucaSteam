package data;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import model.Juego;
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
			System.out.println("Código: " + entrada.getKey() + " | Juego: " + entrada.getValue().getNombre() + " | Plataforma: " + entrada.getValue().getPlataforma() + " | Año: " + entrada.getValue().getFechaPublicacion() + " | Género: " + entrada.getValue().getGenero() + " | Distribuidora: " + entrada.getValue().getDistribuidora());
		}
	}

	public void cargarCSV(String url) {
		
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
		} catch (IOException error) {
			error.printStackTrace();
		}		
	}

	public Juego crearJuego(String[] atributos) {
		
		String nombre = atributos[1];
		String plataforma = atributos[2];
		int fechaPublicacion = 0;
		if(atributos[3].equals("N/A")) {
			fechaPublicacion = -1;
		}else {
			fechaPublicacion = Integer.parseInt(atributos[3]);
		}			
		String genero = atributos[4];
		String distribuidora = atributos[5];
		return new Juego(nombre, plataforma, fechaPublicacion, genero, distribuidora);
	}
	
}