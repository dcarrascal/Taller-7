package Interfaz2;

import java.awt.Component;
import java.awt.Dimension;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class PanelDerecha extends JPanel {
	
	public PanelDerecha(List<String> Botones) {
        JPanel rightPanel = new JPanel();
        Dimension d = new Dimension(200, 10);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  

        add(Box.createVerticalGlue());
        for (String texto: Botones) {
        	
        	Boton boton=new Boton(texto,d);
            boton.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(Box.createVerticalStrut(10));
            this.add(boton);
         

        	
        }
        add(Box.createVerticalGlue());
        
		
	}
	

}
