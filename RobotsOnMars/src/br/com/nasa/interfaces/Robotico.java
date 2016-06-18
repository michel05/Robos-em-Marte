package br.com.nasa.interfaces;

import br.com.nasa.Enumeradores.FaceTo;

public abstract class Robotico implements IRobotico{

	public float posicaoX;
	public float posicaoY;
	public FaceTo faceTo;
	protected IPlateau plateau;
	
	public Robotico(float x, float y, FaceTo faceTo, IPlateau plateau) {
		this.posicaoX = x;
		this.posicaoY = y;
		this.faceTo = faceTo;
		this.plateau = plateau;
	}
	
}
