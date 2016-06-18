package br.com.nasa.fabricas;

import br.com.nasa.Enumeradores.FaceTo;
import br.com.nasa.interfaces.IPlateau;
import br.com.nasa.interfaces.IRobotico;
import br.com.nasa.negocio.Robo;

public class FabricaDeRobo {

	public static IRobotico criaRobo(String[] cordenadas, IPlateau terreno) {
		
		FaceTo faceTo = null;
		switch (cordenadas[2]) {
		case "N":
			faceTo = FaceTo.N;
			break;
		case "E":
			faceTo = FaceTo.E;
			break;
		case "S":
			faceTo = FaceTo.S;
			break;
		case "W":
			faceTo = FaceTo.W;
			break;
		}
		
		Robo robo = new Robo(
				Float.parseFloat(cordenadas[0]),
				Float.parseFloat(cordenadas[1]),
				faceTo,
				terreno);
		return robo;
	}
}
