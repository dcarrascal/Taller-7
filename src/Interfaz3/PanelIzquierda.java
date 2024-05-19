package Interfaz3;
import javax.swing.*;
import java.awt.*;

public class PanelIzquierda extends JPanel {
    private int numeroCuadrados;

    public PanelIzquierda(int numeroCuadrados) {
        this.numeroCuadrados = numeroCuadrados;
    }

    @Override

        // Dibujar los cuadrados seg�n el n�mero especificado
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Obtener el tama�o del panel
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calcular el tama�o y margen de cada cuadrado
            int tamano = Math.min(panelWidth, panelHeight) / numeroCuadrados;
            int margin =0;

            // Dibujar los cuadrados seg�n el n�mero especificado
            for (int i = 0; i < numeroCuadrados; i++) {
                for (int j = 0; j < numeroCuadrados; j++) {
                    int x = margin + j * (tamano + margin);
                    int y = margin + i * (tamano + margin);
                    g2d.setColor(Color.YELLOW); 
                    g2d.fillRect(x, y, tamano, tamano); // Usar fillRect para llenar el cuadrado con color
                    g2d.setColor(Color.BLACK); // Establecer el color negro para el borde
                    g2d.drawRect(x, y, tamano, tamano); // Dibujar el borde del cuadrado
                    
                }
            }
        }
    }

        
    




