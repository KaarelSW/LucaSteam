package data;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import model.Juego;


public @Data class Listado implements IListado{

		// Declaramos un Mapa para almacenar 
		// la lista de juegos
	
		private Map<Integer, Juego> listaJuegos;
		
		public Listado () {
			
			listaJuegos = new HashMap<>();
		}
		
		//Creamos un metodo para recorrer el el mapa 
		
		public void mostrarJuegos(){
			
			for (Map.Entry<Integer, Juego> entrada : listaJuegos.entrySet()) {
			    System.out.println(": " + entrada.getKey() + " & Value: " + entrada.getValue());
			} 
				
			
			
		}
	}


