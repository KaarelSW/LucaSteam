package exceptions;
import java.util.logging.Level;
import java.util.logging.Logger;



public class LucaSteamExcepciones extends Exception {

	private static final long serialVersionUID = 1L;
	private Level level; 
	
	public LucaSteamExcepciones() {
	}

	public LucaSteamExcepciones(String message) {
		super(message);
	}

	public LucaSteamExcepciones(Throwable cause) {
		super(cause);
	}

	public LucaSteamExcepciones(String message, Throwable cause) {
		super(message, cause);
	}
	public LucaSteamExcepciones(String message, int tipo) {
		super(message);
		setLevel(tipo);
	}	

	public void setLevel(int tipo) {

		switch (tipo) {
		case 1:
			level = Level.SEVERE;
			//csv vacío
			break;
		case 2:
			level = Level.WARNING;
			//año inferior a 1958
			break;
		case 3:
			level = Level.INFO;
			break;
		default:
			level = Level.INFO;
			break;
		}
	}

	@Override
	public String toString() {
		Logger.getLogger(LucaSteamExcepciones.class.getName()).log(level, "error", super.getMessage());
		return super.getMessage();
	}
}
