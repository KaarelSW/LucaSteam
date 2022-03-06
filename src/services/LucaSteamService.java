package services;

import data.IListado;
import data.Listado;

public class LucaSteamService implements ILucaSteamService {
	
	private IListado listado = new Listado();

	@Override
	public void listarJuegos() {
		listado.cargarCSV("vgsalesTab.csv"); //A falta de base de datos, hardcodeamos el archivo CSV
        listado.mostrarJuegos();		
    }	

}
