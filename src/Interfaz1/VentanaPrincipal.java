package Interfaz1;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4327094914170572165L;

	public VentanaPrincipal() {
		setTitle("Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
	}
	
	public static void main(String[]args) {
		new VentanaPrincipal();
		
	}

}
