package Interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel implements ActionListener {
    private static final long serialVersionUID = 7809795509416585566L;
    private JLabel etiquetaTamano;
    private JComboBox<String> tamanios;
    private ButtonGroup grupoBotones;
    private int tamanio;
    private int dificultad;

    public PanelSuperior() {
    	this.setBackground(new Color(173, 216, 230));
        etiquetaTamano = new JLabel("Size");
        tamanios = new JComboBox<>();
        tamanios.setPreferredSize(new Dimension(80, 20));
        tamanio=5;

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("5x5");
        model.addElement("7x7");
        model.addElement("9x9");
        tamanios.setModel(model);
        tamanios.addActionListener(this);

        // Inicializar el grupo de botones
        grupoBotones = new ButtonGroup();
       

        // Agregar la etiqueta y el JComboBox al panel actual
        add(etiquetaTamano);
        add(tamanios);
        JLabel etiquetadificultad = new JLabel("Dificultad");
        add(etiquetadificultad);

        agregarBoton("Facil");
        agregarBoton("Medio");
        agregarBoton("Dificil");
    }

    public void agregarBoton(String texto) {
        JRadioButton boton = new JRadioButton(texto);
        boton.setBackground(new Color(173, 216, 230));
        grupoBotones.add(boton);
		boton.setActionCommand(texto);
		boton.addActionListener(this);
        add(boton);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		String modificacion=e.getActionCommand();
		if (modificacion.equals("Facil")) {
			dificultad=1;
		}
		else if (modificacion.equals("Medio")) {
			dificultad=5;
		}
		else if (modificacion.equals("Dificil")) {
			dificultad=10;
		}
		else {
			
			String tamanioString=(String) tamanios.getSelectedItem();
			if (tamanioString.equals("5x5")) {
				tamanio=5;
			}
			else if (tamanioString.equals("7x7")){
				tamanio=7;
			}
			else {
				tamanio=9;
			}
		}
	}

	public int getTamanio() {
		return tamanio;
	}

	public int getDificultad() {
		return dificultad;
	}

}
