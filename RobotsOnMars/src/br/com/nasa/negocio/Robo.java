package br.com.nasa.negocio;

import java.text.DecimalFormat;

import br.com.nasa.Enumeradores.FaceTo;
import br.com.nasa.interfaces.IPlateau;
import br.com.nasa.interfaces.Robotico;

public class Robo extends Robotico{

	private ListaCiclica<FaceTo> listaPosicoes;
	
	public Robo(float x, float y, FaceTo faceTo, IPlateau plateau) {
		super(x, y, faceTo, plateau);
		listaPosicoes = new ListaCiclica<FaceTo>();
		listaPosicoes.add(FaceTo.N);
		listaPosicoes.add(FaceTo.E);
		listaPosicoes.add(FaceTo.S);
		listaPosicoes.add(FaceTo.W);
		
		for (int i = 0; i < listaPosicoes.size(); i++) {
			if(faceTo == listaPosicoes.get(i)) {
				listaPosicoes.setActualIndex(i);
			}
		}
	}

	@Override
	public void mova(String direcao) throws Exception {
		switch (direcao) {
		case "M":
			movaParaFrente();
			break;
		case "L":
			vireParaEsquerda();
			break;
		case "R":
			vireParaDireita();
			break;
		default:
			throw new Exception("Comando Inválido");
		}
		
//		System.out.println("Comando : " + direcao + " - " + exibePosicaoAtual());
		
		if(!plateau.verifiqueLimiteEhValido(this.posicaoX, this.posicaoY)) {
			throw new Exception("O Robo caiu da plataforma =(");
		}
	}

	private void vireParaDireita() {
		this.faceTo = listaPosicoes.next();
	}

	private void vireParaEsquerda() {
		this.faceTo = listaPosicoes.previous();
	}

	private void movaParaFrente() {
		if(this.plateau instanceof PlateauQuadrado) {
			switch (faceTo) {
			case N:
				this.posicaoY++;
				break;
			case E:
				this.posicaoX++;
				break;
			case S:
				this.posicaoY--;
				break;
			case W:
				this.posicaoX--;
				break;
			default:
				break;
			}
		
		} 
		else if(this.plateau instanceof PlateauCircular) {
			switch (faceTo) {
			case N:
				this.posicaoX++;
				break;
			case E:
				this.posicaoY -= (1/ ((PlateauCircular) plateau).raio);
				break;
			case S:
				this.posicaoX--;
				break;
			case W:
				this.posicaoY += (1/ ((PlateauCircular) plateau).raio);
				break;
			default:
				break;
			}
		}
	}
	
	public String exibePosicaoAtual() {
		DecimalFormat df = new DecimalFormat("#"); 
		if(this.plateau instanceof PlateauCircular) {
			return df.format(this.posicaoX) + " " + this.posicaoY + " " + this.faceTo;
		} else {
			return df.format(this.posicaoX) + " " + df.format(this.posicaoY) + " " + this.faceTo;
		}
	}
}
