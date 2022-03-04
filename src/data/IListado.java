package data;

import model.Juego;

public interface IListado {
	
	public void mostrarJuegos();
	//añadir String url
	public void cargarCSV();
	public Juego crearJuego(String[] atributos);

}
