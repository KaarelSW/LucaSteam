package data;

import model.Juego;

public interface IListado {
	
	public void mostrarJuegos();
	//a�adir String url
	public void cargarCSV(String url);
	public Juego crearJuego(String[] atributos);

}
