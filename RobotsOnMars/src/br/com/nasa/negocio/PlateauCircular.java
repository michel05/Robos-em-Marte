package br.com.nasa.negocio;

import br.com.nasa.interfaces.IPlateau;

public class PlateauCircular implements IPlateau {

	public float raio;
	
	public PlateauCircular(float raio) {
		this.raio = raio;
	}
	
	@Override
	public boolean verifiqueLimiteEhValido(float x, float y) {
		return raio >= x;
	}

}
