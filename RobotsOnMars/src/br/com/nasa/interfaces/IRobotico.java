package br.com.nasa.interfaces;

public interface IRobotico {

	void mova(String direcao) throws Exception;
	
	String exibePosicaoAtual();
}
