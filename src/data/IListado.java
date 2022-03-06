package data;

import model.Juego;

public interface IListado {
	
	public void mostrarJuegos();
	//añadir String url
	public void cargarCSV(String url);
	public Juego crearJuego(String[] atributos);

}
