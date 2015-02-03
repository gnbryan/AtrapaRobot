package práctica_9;

public class Habitacion implements LugarDelMapa {
	protected String tipo;
	public static final int NUMLADOS = 4;
	private int numeroHabitacion;
	private final LugarDelMapa lados[] = new LugarDelMapa[NUMLADOS];
	
	public Habitacion(int numHab) {
		setNumeroHabitacion(numHab);
		tipo = "Habitación";
	}
	
	public final LugarDelMapa obtenerLado(Direccion direccion, int comportamiento) {
		if(comportamiento == 0) {
			switch(direccion) {
				case NORTE:		return lados[0];
				case SUR:		return lados[2];
				case ESTE:		return lados[1];
				case OESTE:		return lados[3];
				default:		return null;
			}
		}
		else {		// Movimiento inverso
			switch(direccion) {
				case NORTE:		return lados[2];
				case SUR:		return lados[0];
				case ESTE:		return lados[3];
				case OESTE:		return lados[1];
				default:		return null;
			}
		}
			
	}
	public final void establecerLado(Direccion direccion, LugarDelMapa lugarDelMapa) {
		switch(direccion) {
		case NORTE:
			lados[0] = lugarDelMapa;
			break;
		case SUR:
			lados[2] = lugarDelMapa;
			break;
		case ESTE:
			lados[1] = lugarDelMapa;
			break;
		case OESTE:
			lados[3] = lugarDelMapa;
			break;
		}
	}
	
	@Override
	public void entrar() {
		System.out.println("Dentro de una habitación.");
	}

	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}

	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}

	@Override
	public String getTipo() {
		return tipo;
	}
}
