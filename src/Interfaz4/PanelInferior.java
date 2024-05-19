package Interfaz4;

import java.awt.Dimension;

import javax.swing.*;

public class PanelInferior extends JPanel {
	private JTextField Usuario;
	private JTextField jugadas;
	  public PanelInferior() {
		  JLabel etiquetaJugadas= new JLabel("Jugadas:             ");
		  jugadas= new JTextField("0");
		  JLabel etiquetaUsuario= new JLabel("Jugador:             ");
		   Usuario= new JTextField();
		  jugadas.setPreferredSize(new Dimension(80,20));
		  Usuario.setPreferredSize(new Dimension(80,20));
		  jugadas.setEditable(false);
		  Usuario.setEditable(false);
		  add(etiquetaJugadas);
		  add(jugadas);
		  add(etiquetaUsuario);
		  add(Usuario);
			
	  }

	public void actualizarJugador(String respuesta) {
		Usuario.setText(respuesta);
		// TODO Auto-generated method stub
		
	}

	public void actualizarJugadas() {
		Integer jugadasregistradas=Integer.parseInt(jugadas.getText())+1;
		jugadas.setText(jugadasregistradas.toString());
		// TODO Auto-generated method stub
		
	}
	public void reiniciarJugadas() {
		  jugadas.setText("0");

	}
}
