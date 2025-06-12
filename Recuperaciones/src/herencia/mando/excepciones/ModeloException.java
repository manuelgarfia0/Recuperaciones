package herencia.mando.excepciones;

public class ModeloException extends Exception {

	public String getMessage() {
		return "El modelo introducido es erróneo";
	}

	@Override
	public String toString() {
		return "El modelo introducido es erróneo";
	}

}
