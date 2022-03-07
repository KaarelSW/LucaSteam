/**
 * 
 * @author Grupo02
 * 
 *Nombre: Juego
 *
 *Descripcion: Creamos los enumerados correspondientes a la clase plataforma
 *y se les asocia un atributo String
 *
 *Fecha: 04/03/22
 *
 *Version: 1
 *
 */package model;

public enum Plataforma {
	WII("Nintendo"),
	NES("Nintendo"),
	SNES("Nintendo"),
	DS("Nintendo"),
	X360("Microsoft"),
	GB("Nintendo"),
	PS2("Sony"),
	PS4("Sony"),
	PS3("Sony"),
	N3DS("Nintendo"),
	XONE("Microsoft"),
	GC("Nintendo"),
	PS("Sony"),
	PSP("Sony"),
	GBA("Nintendo"),
	N64("Nintendo"),
	PC("Microsoft"),
	WIIU("Nintendo"),
	XB("Microsoft"),
	DOSMILSEISCIENTOS("Atari"),
	GEN("Sega"),
	SAT("Sega"),
	SCD("Nintendo"),
	WS("Bandai"),
	TG16("NEC"),
	TRESDO("3DO"),
	NG("Nokia"),
	DC("Sega"),
	GG("Sega"),
	PCFX("NEC"),
	PSV("Sony");
	
	private final String empresa;

    private Plataforma(String empresa) {
        this.empresa = empresa;
    }
    
    public String getEmpresa() {
        return empresa;
    }
}
