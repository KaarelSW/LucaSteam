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