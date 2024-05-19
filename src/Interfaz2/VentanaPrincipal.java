package Interfaz2;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4327094914170572165L;

	public VentanaPrincipal(List<String> botonesDerecha) {
		setTitle("Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLayout(new BorderLayout());
		
		PanelDerecha rightPanel=new PanelDerecha(botonesDerecha);
		add(rightPanel, BorderLayout.EAST);
		PanelSuperior panelSuperior=new PanelSuperior();
		add(panelSuperior,BorderLayout.NORTH);
		PanelInferior panelInferior = new PanelInferior();
		add(panelInferior,BorderLayout.SOUTH);
		setVisible(true);

	}
	
	public static void main(String[]args) {
        List<String> botonesTextos = new ArrayList<>();
        botonesTextos.add("NUEVO");
        botonesTextos.add("REINICIAR");
        botonesTextos.add("TOP 10");
        botonesTextos.add("CAMBIAR JUGADOR");

		new VentanaPrincipal(botonesTextos);
		
	}

}
