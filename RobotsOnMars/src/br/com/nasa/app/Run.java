package br.com.nasa.app;

import java.util.Scanner;

import br.com.nasa.fabricas.FabricaDePlateau;
import br.com.nasa.fabricas.FabricaDeRobo;
import br.com.nasa.interfaces.IPlateau;
import br.com.nasa.interfaces.IRobotico;

public class Run {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String firstLine = scanner.nextLine();
		
		String[] dimensoesPlateau = firstLine.split(" ");
		IPlateau plateau = FabricaDePlateau.criePlateau(dimensoesPlateau);
		
		String secondLine = scanner.nextLine();
		String[] cordenadaRobo = secondLine.split(" ");
		
		IRobotico robo = FabricaDeRobo.criaRobo(cordenadaRobo, plateau);
		
		String thirdLine = scanner.nextLine();
		String[] comandos = thirdLine.split("");
		
		try {
			for (int i = 0; i < comandos.length; i++) {
				robo.mova(comandos[i]);
			}
			System.out.println(robo.exibePosicaoAtual());
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
}
