package práctica_9;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class AbstractLaberintoInverso implements I_AbstractLaberinto {

	@Override
	public AppGameContainer crearLaberinto() throws SlickException {
		return new AppGameContainer(new LaberintoInverso("Laberinto Inverso"));
	}

	public Pared fabricarPared() {
		return new Pared();
	}
	
	public Habitacion fabricarHabitacion() {
		return new Habitacion(0);
	}
	
	public HabitacionInversa fabricarHabitacionInversa() {
		return new HabitacionInversa(0);
	}
	
	public Puerta fabricarPuerta() {
		return new Puerta(fabricarHabitacion(), fabricarHabitacion());
	}
}
