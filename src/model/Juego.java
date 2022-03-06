/**
 * 
 * @author Grupo02
 * 
 *Nombre: Juego
 *
 *Descripci�n: Se trata de la clase en la que se almacenar�n los datos de cada juego de los sacados del
 *archivo CSV
 *
 *Fecha: 04/03/22
 *
 *Versi�n: 1
 *
 */

package model;
import lombok.Data;
import lombok.AllArgsConstructor;

public @Data @AllArgsConstructor class Juego {
	
	private String nombre;
	private String plataforma;
	private int fechaPublicacion;
	private String genero;
	private String distribuidora;

}