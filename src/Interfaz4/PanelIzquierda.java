package Interfaz4;
import javax.swing.*;

import Modelo.Tablero;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelIzquierda extends JPanel implements MouseListener {
    private   Tablero tablero=new Tablero(5);
    private VentanaPrincipal ventana;
    private ImageIcon prendido;
    private ImageIcon apagado;
   

    public PanelIzquierda(int numeroCuadrados,VentanaPrincipal ventana) {
    	this.ventana=ventana;
    	prendido = new ImageIcon("./data/Prendido.png");
    	apagado= new ImageIcon("./data/Apagado.png");
        addMouseListener(this);
    }

    @Override

        // Dibujar los cuadrados seg�n el n�mero especificado
    public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawRect(0, 0, 120, 320);

            g2d.fillRect(10, 50, 50, 60);

            // Obtener el tama�o del panel


            // Calcular el tama�o y margen de cada cuadrado
            boolean[][] tableroJuego = tablero.darTablero();
            int ladoTablero = tableroJuego.length;

            int ancho = getWidth() / ladoTablero;
            int alto = getHeight() / ladoTablero;


            // Dibujar los cuadrados seg�n el n�mero especificado
            for (int i = 0; i < ladoTablero; i++) {
                for (int j = 0; j < ladoTablero; j++) {

                    if (tableroJuego[i][j]) {
                        g2d.setColor(Color.YELLOW);
                        g2d.fillRect(i * ancho, j * alto, ancho, alto);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(i * ancho, j * alto, ancho, alto);
                        g2d.drawImage(prendido.getImage(), i * ancho, j * alto, ancho, alto, null); // Establecer el color amarillo para true
                    } else {
                        g2d.setColor(Color.YELLOW);
                        g2d.fillRect(i * ancho, j * alto, ancho, alto);
                        g2d.setColor(Color.BLACK);
                        g2d.drawRect(i * ancho, j * alto, ancho, alto);
                        g2d.drawImage(apagado.getImage(), i * ancho, j * alto, ancho, alto, null);
                    }

                }
            }
        }

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
		repaint();
	}
	
	public void reiniciarTablero() {
		tablero.reiniciar();
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int click_x = e.getX();
		int click_y = e.getY();
		int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
		tablero.jugar(casilla[1], casilla[0]);
		ventana.actualizarjugadas();
		repaint();
		if (tablero.tableroIluminado()) {
			int puntaje=tablero.calcularPuntaje();
			JOptionPane.showMessageDialog(null, "Has ganado! Tu puntaje es de: "+puntaje);
			ventana.verificarTop10(puntaje);
		}
	}
	
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
	int ladoTablero = tablero.darTablero().length;
	int altoPanelTablero = getHeight();
	int anchoPanelTablero = getWidth();
	int altoCasilla = altoPanelTablero / ladoTablero;
	int anchoCasilla = anchoPanelTablero / ladoTablero;
	int fila = (int) (y / altoCasilla);
	int columna = (int) (x / anchoCasilla);
	return new int[] { fila, columna };
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    }

        
    




