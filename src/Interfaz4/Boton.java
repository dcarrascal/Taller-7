package Interfaz4;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Boton extends JButton  { 


	    public Boton(String text, Dimension d,PanelDerecha Panel) {
	        super(text);
	        this.setMaximumSize(d);
	        this.setActionCommand(text);
	        this.addActionListener(Panel);
	    }

	    

}
