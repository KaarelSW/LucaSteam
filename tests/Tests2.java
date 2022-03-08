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
	public void nombre_juego_debe_estar_vacio() {
		String resultado = juego.getNombre();
		assertEquals("", resultado);
	}

	@Test
	public void nombre_juego_debe_ser_null() {
		juego.setNombre(null);
		assertNull(juego.getNombre());
	}

	@Test
	public void plataforma_juego_debe_ser_null() {
		assertNull(juego.getPlataforma());
	}

	@Test
	public void plataforma_juego_no_esta_vacio() {

		assertNotEquals("", juego.getPlataforma());
	}

	@Test
	void URL_incorrecto_deberia_devolver_falso() throws LucaSteamExcepciones {
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
	public void distribuidora_juego_no_deberia_ser_null() {
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
	void juego_se_crea_con_un_nombre_correcto() throws LucaSteamExcepciones {
		String[] juegos = { "1", "Hey Pikachu", "wii", "2000", "shooter", "distribuidora", "datos", "cosas" };
		Juego juego2 = listado.crearJuego(juegos);
		assertEquals("Hey Pikachu", juego2.getNombre());
	}

	@Test
	void juego_se_crea_con_nombre_null() throws LucaSteamExcepciones {
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
		String[] atributos = { "5", "", "wii", "2005", "platform", "distribuidora" };
		Juego juego1 = listado.crearJuego(atributos);
		assertEquals("", juego1.getNombre());
	}
	
	@Test
	void distribuidora_deberia_ser_la_indicada() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Croc", "ps", "2005", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals("distribuidora", listado.getListaJuegos().get(1).getDistribuidora());
	}
	
	@Test
	void distribuidora_deberia_ser_erronea() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Crash Bandicoot", "ps", "2005", "platform", "alfa" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals("beta", listado.getListaJuegos().get(1).getDistribuidora());
	}
	
	@Test
	void dado_un_juego_debe_darse_de_alta_correctamente() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "2005", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals("Sonic", listado.getListaJuegos().get(1).getNombre());
	}
	
	@Test
	void dado_un_juego_no_deberia_darse_de_alta_correctamente() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "2005", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals("Sanic", listado.getListaJuegos().get(1).getNombre());
	}
	
	@Test
	void dado_un_juego_la_plataforma_deberia_ser_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Wii Sports", "wii", "2005", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals(Plataforma.WII, listado.getListaJuegos().get(1).getPlataforma());
	}
	
	@Test
	void dado_un_juego_la_plataforma_deberia_no_ser_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "inFamous", "ps3", "2005", "platform", "alfa" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals(Plataforma.WII, listado.getListaJuegos().get(1).getPlataforma());
	}
	
	@Test
	void dado_un_juego_el_genero_deberia_ser_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "2005", "action", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals(Genero.ACTION, listado.getListaJuegos().get(1).getGenero());
	}
	
	@Test
	void dado_un_juego_el_genero_deberia_no_ser_correcto() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "2005", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals(Genero.ACTION, listado.getListaJuegos().get(1).getGenero());
	}
	
	@Test
	void dado_un_juego_la_fechaPublicacion_deberia_ser_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "1994", "action", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertEquals(1994, listado.getListaJuegos().get(1).getFechaPublicacion());
	}
	
	@Test
	void dado_un_juego_la_fechaPublicacion_deberia_no_ser_correcta() throws LucaSteamExcepciones {
		String[] atributos = { "5", "Sonic", "wii", "1994", "platform", "distribuidora" };
		listado.darDeAltaJuego(atributos);
		assertNotEquals(1993, listado.getListaJuegos().get(1).getFechaPublicacion());
	}
	
	@Test
	void empresa_debe_settearse_correctamente() {
		juego.setPlataforma(Plataforma.DS);
		assertEquals("Nintendo", juego.getPlataforma().getEmpresa());
	}
	
	@Test
	void empresa_se_deberia_settear_incorrectamente() {
		juego.setPlataforma(Plataforma.PS);
		assertNotEquals("Nintendo", juego.getPlataforma().getEmpresa());
	}

	@Test
	void dado_dos_juegos_se_filtra_por_siglo_XX_correctamente() throws LucaSteamExcepciones {
		String[] juego1 = { "1", "Sonic", "wii", "1994", "platform", "distribuidora" };
		String[] juego2 = { "2", "Fifa furbo", "PS4", "2021", "sports", "distribuidora" };
		listado.darDeAltaJuego(juego1);
		listado.darDeAltaJuego(juego2);
		
		int esperado = 1;
		int resultado = listado.filtrarSigloXX().size();
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	void dado_dos_juegos_se_filtra_por_siglo_XX_incorrectamente() throws LucaSteamExcepciones {
		String[] juego1 = { "1", "Fifa skere", "PS4", "2015", "sports", "distribuidora" };
		String[] juego2 = { "2", "Fifa furbo", "PS4", "2013", "sports", "distribuidora" };
		listado.darDeAltaJuego(juego1);
		listado.darDeAltaJuego(juego2);
		
		int esperado = 1;
		int resultado = listado.filtrarSigloXX().size();
		
		assertNotEquals(esperado, resultado);
	}
	
	@Test
	void dado_un_csv_deberia_contar_el_numero_de_distribuidoras() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		assertEquals(579, distribuidoras.size());
	}
	
	@Test
	void dado_un_csv_deberia_contar_mal_el_numero_de_distribuidoras() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		assertNotEquals(580, distribuidoras.size());
	}
	
	@Test
	void dado_un_csv_vacio_deberia_contar_el_numero_de_distribuidoras() throws LucaSteamExcepciones {
		listado.cargarCSV("falso.csv");
		HashSet<String> distribuidoras = listado.mostrarDistribuidoras();
		assertEquals(0, distribuidoras.size());
	}
	
	@Test
	void dado_juegos_debe_mostrar_todas_las_distribuidoras_de_los_mismos() {
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
	void dado_juegos_verificar_que_encuentra_distribuidoras_incorrectas() {
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
	
	@Test
		void dado_un_listado_vacio_deberia_mostrarlo() {
		assertEquals(true, listado.mostrarJuegos().isEmpty());
	}
	
	@Test
	void dado_un_juego_deberia_cargarse_adecuadamente() {
		listado.getListaJuegos().put(1, juego);
		assertEquals(1, listado.mostrarJuegos().size());
	}
	
	@Test
	void dado_un_csv_deberia_percatarse_de_una_plataforma_no_valida_al_filtrar() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(true, listado.filtrarJuegosPlataforma("falso").isEmpty());
	}
	
	@Test
	void dado_un_csv_deberia_percatarse_de_una_empresa_no_valida_al_filtrar() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(false, listado.filtrarJuegosPlataforma("Nintendo").isEmpty());
	}
	
	@Test
	void dado_un_csv_deberia_percatarse_de_un_genero_no_valido_al_filtrar() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(true, listado.filtrarGenero("falso").isEmpty());
	}
	
	@Test
	void dado_un_csv_deberia_filtrar_por_genero() throws LucaSteamExcepciones {
		listado.cargarCSV("vgsalesTab.csv");
		assertEquals(false, listado.filtrarGenero("shooter").isEmpty());
	}

	@Test
	void dado_juegos_se_filtra_por_year_par_correctamente() throws LucaSteamExcepciones {
		String[] juego1 = { "1", "Sonic maincra", "wii", "1993", "platform", "distribuidora" };
		String[] juego2 = { "2", "Fifa pokemon", "PS4", "2022", "sports", "distribuidora" };
		listado.darDeAltaJuego(juego1);
		listado.darDeAltaJuego(juego2);
		
		int esperado = 1;
		int resultado = listado.filtrarPorFechaPar().size();
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	void dado_juegos_se_filtra_por_year_par_incorrectamente() throws LucaSteamExcepciones {
		String[] juego1 = { "1", "Sonic maincra", "wii", "2021", "platform", "distribuidora" };
		String[] juego2 = { "2", "Fifa gormiti", "PS4", "1999", "sports", "distribuidora" };
		listado.darDeAltaJuego(juego1);
		listado.darDeAltaJuego(juego2);
		
		int esperado = 1;
		int resultado = listado.filtrarPorFechaPar().size();
		
		assertNotEquals(esperado, resultado);
	}
	
	
	
}
