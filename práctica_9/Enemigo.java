package práctica_9;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemigo extends Personaje {
	protected Animation robotMalo, arribaMalo, abajoMalo, izquierdaMalo, derechaMalo;
	protected Image[] moverArribaMalo;
	protected Image[] moverAbajoMalo;
	protected Image[] moverIzqMalo;
	protected Image[] moverDerMalo;
	protected Random movimientoAleatorio;
    
	public Enemigo() throws SlickException {
		moverArribaMalo[0] = new Image("Images/robMalo.jpg");
		moverArribaMalo[1] = new Image("Images/robMalo.jpg");
		moverAbajoMalo[0] = new Image("Images/robMalo.jpg");
		moverAbajoMalo[1] = new Image("Images/robMalo.jpg");
		moverIzqMalo[0] = new Image("Images/robMalo.jpg");
		moverIzqMalo[1] = new Image("Images/robMalo.jpg");
		moverDerMalo[0] = new Image("Images/robMalo.jpg");
		moverDerMalo[1] = new Image("Images/robMalo.jpg");
        
        int[] duracion = {300, 300};  					// Duración para mostrar cada frame en milisegundos
		
		arribaMalo = new Animation(moverArribaMalo, duracion, false);
        abajoMalo = new Animation(moverAbajoMalo, duracion, false);
        izquierdaMalo = new Animation(moverIzqMalo, duracion, false);
        derechaMalo = new Animation(moverDerMalo, duracion, false);
		
        robotMalo = derechaMalo;
	}
	
	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

}
