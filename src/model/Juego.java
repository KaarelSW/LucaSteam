/**
 * 
 * @author Grupo02
 * 
 *Nombre: Juego
 *
 *Descripción: Se trata de la clase en la que se almacenarán los datos de cada juego de los sacados del
 *archivo CSV
 *
 *Fecha: 04/03/22
 *
 *Versión: 1
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