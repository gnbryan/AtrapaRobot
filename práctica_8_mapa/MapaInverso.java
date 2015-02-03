package práctica_8_mapa;

import java.util.Random;

import javax.swing.JOptionPane;

import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class MapaInverso extends BasicGame {
	private Animation robotUsuario, arriba, abajo, izquierda, derecha;
    private Animation robotMalo1, arribaMalo1, abajoMalo1, izquierdaMalo1, derechaMalo1;
    private Animation robotMalo2, arribaMalo2, abajoMalo2, izquierdaMalo2, derechaMalo2;
    private TiledMap mapa2;
    private float x, y, xMalo1, yMalo1, xMalo2, yMalo2;
    private boolean atrapadoMalo1, atrapadoMalo2;
    private float velocidadJugador = 0.1F;
    private boolean[][] elementosBloqueados;
    private boolean[][] elementosInversos;
    private static final int TAM = 32;
    
	public MapaInverso(String cabecera) {
		super(cabecera);
		x = 650.0F;				// Coordenadas iniciales X e Y de cada personaje dentro del mapa
		y = 490.0F;
	    xMalo1 = 550.0F;
	    yMalo1 = 230.0F;
	    xMalo2 = 300.0F;
	    yMalo2 = 230.0F;
	    atrapadoMalo1 = false;
	    atrapadoMalo2 = false;
	}

	@Override
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		mapa2.render(0, 0);
		robotUsuario.draw((int) x, (int) y);
		
		if(atrapadoMalo1 == false) 
			robotMalo1.draw((int) xMalo1, (int) yMalo1);
		else
			g.drawString("¡Monstruo 1 atrapado!", 300,400);
		
		if(atrapadoMalo2 == false) 
			robotMalo2.draw((int) xMalo2, (int) yMalo2);
		else
			g.drawString("¡Monstruo 2 atrapado!", 300,400);

	}

	@Override
	public void update(GameContainer container, int tiempo) throws SlickException {
		Random aleat = new Random(System.currentTimeMillis());		// Semilla con el tiempo del sistema
		int aleatorio;
		aleatorio = aleat.nextInt(4);
		
		Input movimiento = container.getInput();

        if(movimiento.isKeyDown(Input.KEY_UP)) {					// Si se ha pulsado la tecla de dirección arriba	
        	robotUsuario = arriba;
            if(!isBloqueado(x, y - tiempo * velocidadJugador)) {			// Si en la posición no hay un elemento bloqueado, actualiza nueva posición
            	if(isInverso(x, y - tiempo * velocidadJugador)) {			// ¿Está en una habitación inversa?
            		y += tiempo * velocidadJugador;
            		robotUsuario = abajo;
            	}
            	else
            		y -= tiempo * velocidadJugador;
            	robotUsuario.update(tiempo);  
            }
        }
        else if(movimiento.isKeyDown(Input.KEY_DOWN)) {				// Si se ha pulsado la tecla de dirección abajo
        	robotUsuario = abajo;
            if(!isBloqueado(x, y + TAM + tiempo * velocidadJugador)) {			// Si en la posición no hay un elemento bloqueado, actualiza nueva posición
            	if(isInverso(x, y + TAM + tiempo * velocidadJugador)) {			// ¿Está en una habitación inversa?
            		y -= tiempo * velocidadJugador;
            		robotUsuario = arriba;
            	}
            	else
            		y += tiempo * velocidadJugador;
            	robotUsuario.update(tiempo);
            }
        }
        else if(movimiento.isKeyDown(Input.KEY_LEFT)) {				// Si se ha pulsado la tecla de dirección izquierda
        	robotUsuario = izquierda;
            if(!isBloqueado(x - tiempo * velocidadJugador, y)) {				// Si en la posición no hay un elemento bloqueado, actualiza nueva posición
            	if(isInverso(x + TAM + tiempo * velocidadJugador, y)) {			// ¿Está en una habitación inversa?
            		robotUsuario.update(tiempo);
            		robotUsuario = derecha;
            		x += tiempo * velocidadJugador;		
            	}
            	else {
            		robotUsuario.update(tiempo);
            		x -= tiempo * velocidadJugador;	
            	}
            }
        }
        else if(movimiento.isKeyDown(Input.KEY_RIGHT)) {			// Si se ha pulsado la tecla de dirección derecha
        	robotUsuario = derecha;
            if(!isBloqueado(x + TAM + tiempo * velocidadJugador, y)) {			// Si en la posición no hay un elemento bloqueado, actualiza nueva posición
            	if(isInverso(x - tiempo * velocidadJugador, y)) {				// ¿Está en una habitación inversa?
            		robotUsuario.update(tiempo);
            		robotUsuario = izquierda;
            		x -= tiempo * velocidadJugador;		
            	}
            	else {
            		robotUsuario.update(tiempo);
            		x += tiempo * velocidadJugador;			 
            	}
            }
        }	
        
        
        // Movimientos del robot malo 1

        if(aleatorio == 0) {      // Hacia arriba
        	robotMalo1 = abajoMalo1;
        	if(!isBloqueado(xMalo1, yMalo1 - tiempo * 0.1f)) {
                robotMalo1.update(tiempo);
                yMalo1 -= tiempo * 0.5f;
            }
        }
        else if(aleatorio == 1) {      // Hacia abajo
        	robotMalo1 = arribaMalo1;
        	if(!isBloqueado(xMalo1, yMalo1 + TAM + tiempo * 0.1f)) {
                robotMalo1.update(tiempo);
                yMalo1 += tiempo * 0.5f;
            }
        }
        else if(aleatorio == 2) {     // Hacia la izquierda
        	robotMalo1 = izquierdaMalo1;
            if(!isBloqueado(xMalo1 - tiempo * 0.1f, yMalo1)) {
                robotMalo1.update(tiempo);
                xMalo1 -= tiempo * 0.5f;
            }
        }
        
        else if(aleatorio == 3) { 		// Hacia la derecha
        	robotMalo1 = derechaMalo1;
            if(!isBloqueado(xMalo1 + TAM + tiempo * 0.1f, yMalo1)) {
                robotMalo1.update(tiempo);
                xMalo1 += tiempo * 0.5f;
            }
        }
        
        
        // Movimientos del robot malo 2
        
		Random aleat2 = new Random(System.currentTimeMillis() - 1500);		// Semilla con el tiempo del sistema -1500
		int aleatorio2;
		aleatorio2 = aleat2.nextInt(4);
        
        if(aleatorio2 == 0) {      // Hacia arriba
        	robotMalo2 = abajoMalo2;
        	if(!isBloqueado(xMalo2, yMalo2 - tiempo * 0.1f)) {
                robotMalo2.update(tiempo);
                yMalo2 -= tiempo * 0.5f;
            }
        }
        else if(aleatorio2 == 1) {      // Hacia abajo
        	robotMalo2 = arribaMalo2;
        	if(!isBloqueado(xMalo2, yMalo2 + TAM + tiempo * 0.1f)) {
                robotMalo2.update(tiempo);
                yMalo2 += tiempo * 0.5f;
            }
        }
        else if(aleatorio2 == 2) {     // Hacia la izquierda
        	robotMalo2 = izquierdaMalo2;
            if(!isBloqueado(xMalo2 - tiempo * 0.1f, yMalo2)) {
                robotMalo2.update(tiempo);
                xMalo2 -= tiempo * 0.5f;
            }
        }
        
        else if(aleatorio2 == 3) { 		// Hacia la derecha
        	robotMalo2 = derechaMalo2;
            if(!isBloqueado(xMalo2 + TAM + tiempo * 0.1f, yMalo2)) {
                robotMalo2.update(tiempo);
                xMalo2 += tiempo * 0.5f;
            }
        }
        
        
        // ¿Atrapé a los robots malos?
        if(isAtrapadoMalo(x-tiempo,y-tiempo,xMalo1-tiempo,yMalo1-tiempo)) {
        	velocidadJugador = 0.3f;
        	atrapadoMalo1 = true;
        }
        
        if(isAtrapadoMalo(x-tiempo,y-tiempo,xMalo2-tiempo,yMalo2-tiempo)) {
        	velocidadJugador = 0.3f;
        	atrapadoMalo2 = true;
        }
        
        if(atrapadoMalo1 && atrapadoMalo2)
        	JOptionPane.showMessageDialog( null, "¡Todos los monstruos del juego atrapados!" );
	}
	
	@Override
	public void init(GameContainer arg0) throws SlickException {
		Image[] moverArriba = {new Image("Images/robotArriba.jpg"), new Image("Images/robotArriba.jpg")};
        Image[] moverAbajo = {new Image("Images/robotAbajo.jpg"), new Image("Images/robotAbajo.jpg")};
        Image[] moverIzquierda = {new Image("Images/robotIzq.jpg"), new Image("Images/robotIzq.jpg")};
        Image[] moverDerecha = {new Image("Images/robot.jpg"), new Image("Images/robot.jpg")};
        
		Image[] moverArribaMalo = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};
        Image[] moverAbajoMalo = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};
        Image[] moverIzqMalo = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};
        Image[] moverDerMalo = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};
        
		Image[] moverArribaMalo2 = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};
        Image[] moverAbajoMalo2 = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};
        Image[] moverIzqMalo2 = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};
        Image[] moverDerMalo2 = {new Image("Images/robMalo.jpg"), new Image("Images/robMalo.jpg")};

		mapa2 = new TiledMap("Images/mapa2.tmx");		// Creación del mapa		
		int[] duracion = {300, 300};  					// Duración para mostrar cada frame en milisegundos
		
		arriba = new Animation(moverArriba, duracion, false);
		abajo = new Animation(moverAbajo, duracion, false);
		izquierda = new Animation(moverIzquierda, duracion, false);
		derecha = new Animation(moverDerecha, duracion, false);
        
		arribaMalo1 = new Animation(moverArribaMalo, duracion, false);
        abajoMalo1 = new Animation(moverAbajoMalo, duracion, false);
        izquierdaMalo1 = new Animation(moverIzqMalo, duracion, false);
        derechaMalo1 = new Animation(moverDerMalo, duracion, false);
        
		arribaMalo2 = new Animation(moverArribaMalo2, duracion, false);
        abajoMalo2 = new Animation(moverAbajoMalo2, duracion, false);
        izquierdaMalo2 = new Animation(moverIzqMalo2, duracion, false);
        derechaMalo2 = new Animation(moverDerMalo2, duracion, false);
        
        // Imagen que carga por defecto cada personaje cuando se inicia el mapa
        robotUsuario = derecha;
        robotMalo1 = derechaMalo1;
        robotMalo2 = derechaMalo2;
        
        elementosBloqueados = new boolean[mapa2.getWidth()][mapa2.getHeight()];
        elementosInversos = new boolean[mapa2.getWidth()][mapa2.getHeight()];

        // Se establecen cuáles elementos del mapa serán imposibles de atravesar para los personajes (Paredes) o con movimientos inversos (Habitaciones)
        for(int i = 0; i < mapa2.getWidth(); i++) {
             for(int j = 0; j < mapa2.getHeight(); j++) {
                 int id = mapa2.getTileId(i, j, 0);
                 String propiedad = mapa2.getTileProperty(id, "colision", "false");
                 String propiedad2 = mapa2.getTileProperty(id, "inversa", "false");
                 if("true".equals(propiedad))
                     elementosBloqueados[i][j] = true;  
                 if("true".equals(propiedad2))
                	 elementosInversos[i][j] = true;  
             }
         }
	}
	
	private boolean isAtrapadoMalo(float x, float y, float x1, float y1) {
		return ((((int)x / TAM) == ((int)x1 / TAM)) && (((int)y / TAM) == ((int)y1 / TAM)));
	}
	 
	private boolean isBloqueado(float x, float y) {
        int bloqueoX = (int) x / TAM;
        int bloqueoY = (int) y / TAM;
        return elementosBloqueados[bloqueoX][bloqueoY];
	}
	
	private boolean isInverso(float x, float y) {
        int inversoX = (int) x / TAM;
        int inversoY = (int) y / TAM;
        return elementosInversos[inversoX][inversoY];
	}

}
