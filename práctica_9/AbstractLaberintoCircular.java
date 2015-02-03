package práctica_9;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class AbstractLaberintoCircular implements I_AbstractLaberinto {

	@Override
	public AppGameContainer crearLaberinto() throws SlickException {
		return new AppGameContainer(new LaberintoCircular("Laberinto Circular"));
	}
	
	public Pared fabricarPared() {
		return new Pared();
	}
	
	public Habitacion fabricarHabitacion() {
		return new Habitacion(0);
	}
	
	public Puerta fabricarPuerta() {
		return new Puerta(fabricarHabitacion(), fabricarHabitacion());
	}
}
