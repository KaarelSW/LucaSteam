package data;

import model.Juego;

public interface IListado {
	
	public void mostrarJuegos();
	//a�adir String url
	public void cargarCSV();
	public Juego crearJuego(String[] atributos);

}
