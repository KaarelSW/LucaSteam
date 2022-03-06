import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import data.IListado;
import data.Listado;
import model.Juego;

class Tests2 {
	
	Juego juego = new Juego("", "", 2003, "SHOOTER", "Holi");
	IListado listado = new Listado();

	@Test
	public void nombre_juego_esta_vacio() {
		String resultado = juego.getNombre();
		assertEquals("", resultado);
	}

	@Test
	public void nombre_juego_es_null() {
		juego.setNombre(null);
		String resultado = juego.getNombre();
		assertEquals(null, resultado);
	}

	@Test
	public void plataforma_juego_es_null() {
		juego.setPlataforma(null);
		String resultado = juego.getPlataforma();
		assertEquals(null, resultado);
	}

	@Test
	public void plataforma_juego_esta_vacio() {
		String resultado = juego.getPlataforma();
		assertEquals("", resultado);
	}

	@Test
	void testURLIncorrectoDevuelveFalso() {
		boolean noEncontrado = listado.cargarCSV("urlfalso.csv");
		assertEquals(false, noEncontrado);
	}

}
