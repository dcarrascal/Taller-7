package Interfaz3;

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

    public PanelSuperior() {
        etiquetaTamano = new JLabel("Size");
        tamanios = new JComboBox<>();
        tamanios.setPreferredSize(new Dimension(80, 20));

        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("5x5");
        model.addElement("7x7");
        model.addElement("9x9");
        tamanios.setModel(model);

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
        grupoBotones.add(boton);
        add(boton);
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
