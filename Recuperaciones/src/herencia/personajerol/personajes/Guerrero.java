package herencia.personajerol.personajes;

import herencia.personajerol.excepciones.ManaNegativoException;
import herencia.personajerol.excepciones.VidaNegativaException;
import herencia.personajerol.interfaces.Ataque;
import herencia.personajerol.interfaces.Defensa;

public class Guerrero extends Personaje implements Ataque, Defensa {

	public Guerrero(String nombre, int pVida, int pMana) throws VidaNegativaException, ManaNegativoException {
		super(nombre, pVida, pMana);
	}

	@Override
	public void defender(Personaje per) {
		per.activaEscudo();
	}

	@Override
	public boolean atacar(Personaje per) {

		boolean res = false;
		int cant = (int) (this.pMana * 0.05);

		if (this.pMana >= cant) {
			this.pMana -= cant;
			per.recibirDaño(cant);
			res = true;
		}

		return res;
	}

	@Override
	public String toString() {
		return "Guerrero - " + super.toString();
	}

}