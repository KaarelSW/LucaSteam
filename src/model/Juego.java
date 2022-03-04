package model;
import lombok.Data;

public @Data class Juego {
	
	private String nombre;
	private String plataforma;
	private int fechaPublicacion;
	private String genero;
	private String distribuidora;

}