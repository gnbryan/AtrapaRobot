package práctica_9;

public class Pared implements LugarDelMapa {
	protected String tipo;
	public Pared() {
		tipo = "Pared";
	}
	
	@Override
	public void entrar() {
		System.out.print("Me doy con una pared.");
	}

	@Override
	public String getTipo() {
		return tipo;
	}
}
