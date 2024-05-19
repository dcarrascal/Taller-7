package Interfaz3;

import java.awt.Dimension;

import javax.swing.*;

public class PanelInferior extends JPanel {
	  public PanelInferior() {
		  JLabel etiquetaJugadas= new JLabel("Jugadas:             ");
		  JTextField jugadas= new JTextField("0");
		  JLabel etiquetaUsuario= new JLabel("Jugador:             ");
		  JTextField Usuario= new JTextField();
		  jugadas.setPreferredSize(new Dimension(80,20));
		  Usuario.setPreferredSize(new Dimension(80,20));
		  jugadas.setEditable(false);
		  Usuario.setEditable(false);
		  add(etiquetaJugadas);
		  add(jugadas);
		  add(etiquetaUsuario);
		  add(Usuario);
			
	  }
}
