package data;

import model.Juego;

public interface IListado {
	
	public void mostrarJuegos();
	public void cargarCSV(String url);
	public Juego crearJuego(String[] atributos);

}
