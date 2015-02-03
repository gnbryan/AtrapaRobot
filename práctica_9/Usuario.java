package práctica_9;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Usuario extends Personaje {
	protected Direccion direccion;
	protected Animation robotUsuario, arriba, abajo, izquierda, derecha;
	protected Image[] moverArriba;
	protected Image[] moverAbajo;
	protected Image[] moverIzquierda;
	protected Image[] moverDerecha;
	
	public Usuario() throws SlickException {
		moverArriba[0] = new Image("Images/robotArriba.jpg");
		moverArriba[1] = new Image("Images/robotArriba.jpg");
		moverAbajo[0] = new Image("Images/robotAbajo.jpg");
		moverAbajo[1] = new Image("Images/robotAbajo.jpg");
		moverIzquierda[0] = new Image("Images/robotIzq.jpg");
		moverIzquierda[1] = new Image("Images/robotIzq.jpg");
		moverDerecha[0] = new Image("Images/robot.jpg");
		moverDerecha[1] = new Image("Images/robot.jpg");
        
        int[] duracion = {300, 300};  					// Duración para mostrar cada frame en milisegundos
		
		arriba = new Animation(moverArriba, duracion, false);
		abajo = new Animation(moverAbajo, duracion, false);
		izquierda = new Animation(moverIzquierda, duracion, false);
		derecha = new Animation(moverDerecha, duracion, false);
		
		robotUsuario = derecha;
	}
	
	@Override
	public void mover() {
		// TODO Auto-generated method stub

	}

}
