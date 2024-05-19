package Interfaz2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Boton extends JButton implements ActionListener  { 


	    public Boton(String text, Dimension d) {
	        super(text);
	        this.addActionListener(this);
	        this.setMaximumSize(d);
	        
	    }

	    
	    public void actionPerformed(ActionEvent e)
	    {
	    	{
                // Obtener el bot�n que gener� el evento
	    		Boton sourceButton = (Boton) e.getSource();
                // Mostrar el nombre del bot�n
                JOptionPane.showMessageDialog(null, "Bot�n presionado: " + sourceButton.getText());
            }
	    } 
}
