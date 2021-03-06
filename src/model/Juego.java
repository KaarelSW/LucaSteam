/**
 * 
 * @author Grupo02
 * 
 *Nombre: Juego
 *
 *Descripcion: Se trata de la clase en la que se almacenaran los datos de cada juego de los sacados del
 *archivo CSV
 *
 *Fecha: 04/03/22
 *
 *Version: 1
 *
 */

package model;
import lombok.Data;
import lombok.AllArgsConstructor;

public @Data @AllArgsConstructor class Juego {
	
	private String nombre;
	private Plataforma plataforma;
	private int fechaPublicacion;
	private Genero genero;
	private String distribuidora;
	
	@Override
	public String toString() {
		return "Juego: " + this.getNombre() + " | Plataforma: " + this.getPlataforma() + " | Año: " + this.getFechaPublicacion() + " | Género: " + this.getGenero() + " | Distribuidora: " + this.getDistribuidora();
	}
	
	

}