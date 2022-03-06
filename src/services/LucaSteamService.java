package services;

import data.IListado;
import data.Listado;

public class LucaSteamService implements ILucaSteamService {
	
	private IListado listado = new Listado();

	@Override
	public void listarJuegos() {
		listado.cargarCSV();
        listado.mostrarJuegos();		
    }	

}
