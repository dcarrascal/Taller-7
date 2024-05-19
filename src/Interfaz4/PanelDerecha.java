package Interfaz4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelDerecha extends JPanel implements ActionListener {
	private VentanaPrincipal ventana;
	public PanelDerecha(List<String> Botones,VentanaPrincipal ventana) {
		this.ventana=ventana;
        Dimension d = new Dimension(200, 10);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  
    	this.setBackground(new Color(173, 216, 230));

        add(Box.createVerticalGlue());
        for (String texto: Botones) {
        	
        	Boton boton=new Boton(texto,d,this);
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(Box.createVerticalStrut(10));
            this.add(boton);
         

        	
        }
        add(Box.createVerticalGlue());
        
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action=e.getActionCommand();
		if (action.equals("NUEVO")) {
			int tamanio=ventana.getNuevoTamanio();
			int dificultad=ventana.getNuevaDificultad();
			ventana.nuevoTablero(tamanio,dificultad);
		}
		else if(action.equals("REINICIAR")) {
			ventana.reiniciarTablero();
		}
		else if(action.equals("TOP")) {
			ventana.mostrarTop10();
		}
		else {
		    String respuesta = JOptionPane.showInputDialog(null, "Ingresa el nombre del nuevo jugador:");
		    if (respuesta != null) { // Verificar si se ingres� un nombre
		        ventana.actualizarNuevoJugador(respuesta);
		    }
		}
		
	}
	
	

}
