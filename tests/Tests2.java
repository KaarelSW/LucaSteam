import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import data.IListado;
import data.Listado;
import exceptions.LucaSteamExcepciones;
import model.Genero;
import model.Juego;
import model.Plataforma;

class Tests2 {
	
	Listado listado = new Listado();
	Juego juego = new Juego("", null, 2003, Genero.SHOOTER, "Holi");

	@Test
	public void nombre_juego_esta_vacio() {
		String resultado = juego.getNombre();
		assertEquals("", resultado);
	}

	@Test
	public void nombre_juego_es_null() {
		juego.setNombre(null);
		assertNull(juego.getNombre());
	}

	@Test
	public void plataforma_juego_es_null() {
		assertNull(juego.getPlataforma());
	}

	@Test
	public void plataforma_juego_no_esta_vacio() {

		assertNotEquals("", juego.getPlataforma());
	}

	@Test
	void URL_incorrecto_devuelve_falso() throws LucaSteamExcepciones {
		IListado listado = new Listado();
		boolean noEncontrado = listado.cargarCSV("urlfalso.csv");
		assertEquals(false, noEncontrado);
	}
	
	@Test
	void listado_no_vacio_despues_de_cargar() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(false, listado.getListaJuegos().isEmpty());
	}


	@Test
	public void distribuidora_juego_no_es_null() {
		assertNotNull(juego.getDistribuidora());
	}

	@Test
	public void distribuidora_juego_no_esta_vacio() {
		String resultado = juego.getDistribuidora();
		assertNotEquals("", resultado);
	}

	@Test
	public void fechaPublicacion_juego_no_es_null() {
		assertNotNull(juego.getFechaPublicacion());
	}

	@Test
	public void fechaPublicacion_juego_no_esta_vacio() {
		int resultado = juego.getFechaPublicacion();
		assertNotEquals("", resultado);
	}

	@Test
	public void fechaPublicacion_mayor_o_igual_que_1958() {
		assertTrue(juego.getFechaPublicacion() >= 1958);
	}

	@Test
	public void fechaPublicacion_menor_que_1958() {
		juego.setFechaPublicacion(1492);
		assertTrue(juego.getFechaPublicacion() < 1958);
	}
	
	@Test
	public void genero_juego__es_null() {
		juego.setGenero(null);
		assertEquals(null, juego.getGenero());
	}

	@Test
	public void distribuidora_se_edita_correctamente() {
		juego.setDistribuidora("Cristiano");
		assertEquals("Cristiano", juego.getDistribuidora());
	}

	@Test
	void crear_juego_con_nombre_correcto() throws LucaSteamExcepciones {
		String[] juegos = { "1", "Hey Pikachu", "wii", "2000", "shooter", "distribuidora", "datos", "cosas" };
		Juego juego2 = listado.crearJuego(juegos);
		assertEquals("Hey Pikachu", juego2.getNombre());
	}

	@Test
	void crear_juego_con_atributos_nulo() throws LucaSteamExcepciones {
		String[] juegos = { null, null, "wii", "2000", "platform", null, null, null };
		Juego juego3 = listado.crearJuego(juegos);
		assertNull(juego3.getNombre());
	}

	@Test
	void crear_juego_crea_instancia_de_juego() throws LucaSteamExcepciones {
		String[] atributos = { "1", "Hey Pikachu", "wii", "2000", "shooter", "distribuidora", "datos", "cosas" };
		Juego juego2 = listado.crearJuego(atributos);
		assertEquals(true, juego2 instanceof Juego);
	}
	
	@Test
	void crear_juego_con_nombre_vacio() throws LucaSteamExcepciones {
		String[] atributos = { "5", "", "wii", "5", "platform", "distribuidora" };
		Juego juego1 = listado.crearJuego(atributos);
		assertEquals("", juego1.getNombre());
	}
	
	@Test
	void comprobar_distribuidora_juego_al_dar_alta_es_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Croc", "ps", "5", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals("distribuidora", listado.getListaJuegos().get(1).getDistribuidora());
	}
	
	@Test
	void comprobar_distribuidora_juego_al_dar_alta_no_es_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Crash Bandicoot", "ps", "5", "platform", "alfa" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals("beta", listado.getListaJuegos().get(1).getDistribuidora());
	}
	
	@Test
	void comprobar_nombre_juego_al_dar_alta_es_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "5", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals("Sonic", listado.getListaJuegos().get(1).getNombre());
	}
	
	@Test
	void comprobar_nombre_juego_al_dar_alta_no_es_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "5", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals("Sanic", listado.getListaJuegos().get(1).getNombre());
	}
	
	@Test
	void comprobar_plataforma_juego_al_dar_alta_es_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Wii Sports", "wii", "5", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals(Plataforma.WII, listado.getListaJuegos().get(1).getPlataforma());
	}
	
	@Test
	void comprobar_plataforma_juego_al_dar_alta_no_es_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "inFamous", "ps3", "5", "platform", "alfa" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals(Plataforma.WII, listado.getListaJuegos().get(1).getPlataforma());
	}
	
	@Test
	void comprobar_genero_juego_al_dar_alta_es_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "5", "action", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals(Genero.ACTION, listado.getListaJuegos().get(1).getGenero());
	}
	
	@Test
	void comprobar_genero_juego_al_dar_alta_no_es_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "5", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals(Genero.ACTION, listado.getListaJuegos().get(1).getGenero());
	}
	
	@Test
	void comprobar_fecha_publicacion_juego_al_dar_alta_es_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "1994", "action", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals(1994, listado.getListaJuegos().get(1).getFechaPublicacion());
	}
	
	@Test
	void comprobar_fecha_publicacion_juego_al_dar_alta_no_es_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "1994", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals(1993, listado.getListaJuegos().get(1).getFechaPublicacion());
	}
	
	@Test
	void comprobar_empresa_plataforma() {
		juego.setPlataforma(Plataforma.DS);
		assertEquals("Nintendo", juego.getPlataforma().getEmpresa());
	}
	
	@Test
	void comprobar_empresa_erronea_plataforma() {
		juego.setPlataforma(Plataforma.PS);
		assertNotEquals("Nintendo", juego.getPlataforma().getEmpresa());
	}

	@Test
	void filtrarSigloXX_cuenta_bien() throws LucaSteamExcepciones {
		String[] juego1 = { "1", "Sonic", "wii", "1994", "platform", "distribuidora" };
		String[] juego2 = { "2", "Fifa furbo", "PS4", "2023", "sports", "distribuidora" };
		listado.darDeAltaJuego(juego1);
		listado.darDeAltaJuego(juego2);
		
		int esperado = 1;
		int resultado = listado.filtrarSigloXX().size();
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	void filtrarSigloXX_cuenta_mal() throws LucaSteamExcepciones {
		String[] juego1 = { "1", "Fifa skere", "PS4", "2025", "sports", "distribuidora" };
		String[] juego2 = { "2", "Fifa furbo", "PS4", "2023", "sports", "distribuidora" };
		listado.darDeAltaJuego(juego1);
		listado.darDeAltaJuego(juego2);
		
		int esperado = 1;
		int resultado = listado.filtrarSigloXX().size();
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	void comprobar_mostrar_distribuidoras_numero_correcto() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		assertEquals(579, distribuidoras.size());
	}
	
	@Test
	void comprobar_mostrar_distribuidoras_numero_incorrecto() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		assertNotEquals(580, distribuidoras.size());
	}
	
	@Test
	void comprobar_mostrar_distribuidoras_lista_vacia() throws LucaSteamExcepciones {
		listado.cargarCSV("falso.csv");
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		assertEquals(0, distribuidoras.size());
	}
	
	@Test
	void comprobar_mostrar_distribuidoras_correctamente() {
		Juego juego2 = new Juego("Sonic", Plataforma.WII, 1994, Genero.PLATFORM, "distribuidora");
		Juego juego3 = new Juego("Sonic", Plataforma.WII, 1994, Genero.PLATFORM, "noentiendo");
		listado.getListaJuegos().put(1, juego);
		listado.getListaJuegos().put(2, juego2);
		listado.getListaJuegos().put(3, juego3);
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		HashSet<String> esperado = new HashSet<String>();
		esperado.add("Holi");
		esperado.add("distribuidora");
		esperado.add("noentiendo");
		assertEquals(esperado, distribuidoras);
	}
	
	@Test
		void comprobar_mostrar_juegos_vacio() {
		assertEquals(true, listado.mostrarJuegos().isEmpty());
	}
	
	@Test
	void comprobar_mostrar_juegos_cargado() {
		listado.getListaJuegos().put(1, juego);
		assertEquals(1, listado.mostrarJuegos().size());
	}
	
	@Test
	void comprobar_empresa_plataforma_no_valida() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(true, listado.filtrarJuegosPlataforma("falso").isEmpty());
	}
	
	@Test
	void comprobar_empresa_plataforma_valida() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(false, listado.filtrarJuegosPlataforma("Nintendo").isEmpty());
	}
	
	@Test
	void comprobar_filtrado_genero_invalido() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(true, listado.filtrarGenero("falso").isEmpty());
	}
	
	@Test
	void comprobar_filtrado_genero_valido() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(false, listado.filtrarGenero("shooter").isEmpty());
	}
	
	@Test
	void comprobar_mostrar_distribuidoras_incorrectamente() {
		Juego juego2 = new Juego("Sonic", Plataforma.WII, 1994, Genero.PLATFORM, "distribuidora");
		Juego juego3 = new Juego("Sonic", Plataforma.WII, 1994, Genero.PLATFORM, "noentiendo");
		listado.getListaJuegos().put(1, juego);
		listado.getListaJuegos().put(2, juego2);
		listado.getListaJuegos().put(3, juego3);
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		HashSet<String> esperado = new HashSet<String>();
		esperado.add("Holi");
		esperado.add("distribuidore");
		esperado.add("sientiendo");
		assertNotEquals(esperado, distribuidoras);
	}
	
}
