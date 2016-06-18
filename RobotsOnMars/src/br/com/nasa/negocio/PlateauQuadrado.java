package br.com.nasa.negocio;

import br.com.nasa.interfaces.IPlateau;

public class PlateauQuadrado implements IPlateau{

	public float x;
	public float y;
	
	public PlateauQuadrado(float x, float y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean verifiqueLimiteEhValido(float x, float y) {
		return (x <= this.x && y <= this.y);
	}
}
