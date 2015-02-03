package práctica_9;

public abstract class Personaje {
	protected I_Comportamiento comportamiento;
	protected float posX;
	protected float posY;
	
	public float getPosX() {
		return posX;
	}
	
	public void setPosX(float posX) {
		this.posX = posX;
	}
	
	public float getPosY() {
		return posY;
	}
	
	public void setPosY(float posY) {
		this.posY = posY;
	}
	
	public void mover() {
		comportamiento.mover();
	}
}
