package br.com.nasa.fabricas;

import br.com.nasa.interfaces.IPlateau;
import br.com.nasa.negocio.PlateauCircular;
import br.com.nasa.negocio.PlateauQuadrado;

public class FabricaDePlateau {

	public static IPlateau criePlateau(String[] dimensoesPlateau) {
		if(dimensoesPlateau.length > 1) {
			return new PlateauQuadrado(
						Float.parseFloat(dimensoesPlateau[0]),
						Float.parseFloat(dimensoesPlateau[1]));
		} else {
			return new PlateauCircular(Float.parseFloat(dimensoesPlateau[0]));
		}
	}
}
