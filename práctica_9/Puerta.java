package práctica_9;

public class Puerta implements LugarDelMapa {
	protected Habitacion habitacion1; 
	protected Habitacion habitacion2;
	protected boolean estaAbierta; 
	protected String tipo;
	
	public Puerta(Habitacion h1, Habitacion h2) {
		habitacion1 = h1;
		habitacion2 = h2;
		estaAbierta = true;
		tipo = "Puerta";
	}

	public final Habitacion otroLadoDe(Habitacion habitacion){ 
		if(habitacion.equals(habitacion1))
			return habitacion1;
		else
			return habitacion2;
	}
	
	@Override
	public void entrar() {
		System.out.print("Atravesando la puerta entre la habitación " + habitacion1.getNumeroHabitacion() + " y la " + habitacion2.getNumeroHabitacion() + ".");
	}
	
	public boolean isEstaAbierta() {
		return estaAbierta;
	}

	public void setEstaAbierta(boolean ab) {
		estaAbierta = ab;
	}

	@Override
	public String getTipo() {
		return tipo;
	}
}
