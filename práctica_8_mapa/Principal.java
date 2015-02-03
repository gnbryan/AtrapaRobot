package práctica_8_mapa;

import java.util.Scanner;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Principal {
	public static void main(String[] args) throws SlickException {
		AppGameContainer appgc = null;
		Scanner sc = new Scanner(System.in);
		int eleccion;
		
		System.out.println("Seleccione un mapa a jugar: ");
		System.out.println("\t1. Mapa Circular. ");
		System.out.println("\t2. Mapa inverso. ");
		System.out.print("Elección: ");  eleccion = sc.nextInt();
		
		switch(eleccion) {
		case 1:		appgc = new AppGameContainer(new MapaCircular("Mapa Circular con Slick2D y TiledMap"));
					break;
		case 2:		appgc = new AppGameContainer(new MapaInverso("Mapa Inverso con Slick2D y TiledMap"));
					break;				
		}

		appgc.setDisplayMode(936, 800, false);
		appgc.setShowFPS(false);
		appgc.start();
		sc.close();
	}
}