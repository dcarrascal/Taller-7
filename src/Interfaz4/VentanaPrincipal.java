package Interfaz4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import Modelo.RegistroTop10;
import Modelo.Tablero;
import Modelo.Top10;



public class VentanaPrincipal extends JFrame{
	private PanelDerecha rightPanel;
	private PanelSuperior panelSuperior;
	private PanelInferior panelInferior;
	private PanelIzquierda panelIzquierda;
	private Top10 top;
	private String jugadoractual;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4327094914170572165L;

	public VentanaPrincipal(List<String> botonesDerecha) {
		setTitle("Lights Out");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLayout(new BorderLayout());
		top= new Top10();
		File registros=new File("./data/top10.csv");
		top.cargarRecords(registros);
		jugadoractual=null;
		
		 rightPanel=new PanelDerecha(botonesDerecha,this);
		add(rightPanel, BorderLayout.EAST);
		 panelSuperior=new PanelSuperior();
		add(panelSuperior,BorderLayout.NORTH);
		 panelInferior = new PanelInferior();
		add(panelInferior,BorderLayout.SOUTH);
		
         panelIzquierda = new PanelIzquierda(panelSuperior.getTamanio(),this);
        add(panelIzquierda, BorderLayout.CENTER); // Agregar al centro para que ocupe el espacio principal

 // Ajustar el tama�o de la ventana a los componentes

        setVisible(true);
		

	}
	
	public static void main(String[]args) {
        List<String> botonesTextos = new ArrayList<>();
        botonesTextos.add("NUEVO");
        botonesTextos.add("REINICIAR");
        botonesTextos.add("TOP");
        botonesTextos.add("CAMBIAR JUGADOR");

		new VentanaPrincipal(botonesTextos);
		
	}

	public void nuevoTablero(int tamanio, int dificultad) {
		Tablero tablero=new Tablero(tamanio);
		tablero.desordenar(dificultad);
		panelIzquierda.setTablero(tablero);
		panelInferior.reiniciarJugadas();
		
	}

	public int getNuevaDificultad() {
		return panelSuperior.getDificultad();
	}

	public int getNuevoTamanio() {
		return panelSuperior.getTamanio();
	}

	public void reiniciarTablero() {
		panelIzquierda.reiniciarTablero();
		
		
	}

	public void mostrarTop10() {
	    JPanel panel = new JPanel(new BorderLayout());
	    DefaultListModel<String> listModel = new DefaultListModel<>();
	    for (RegistroTop10 registro : top.darRegistros()) {
	        String linea = registro.toString();
	        listModel.addElement(linea);
	    }
	    JList<String> jList = new JList<>(listModel);
	    jList.setCellRenderer(new ListCellRenderer<String>() {
	        @Override
	        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
	            JLabel label = new JLabel(value);
	            label.setOpaque(true);
	            label.setFont(new Font("Arial", Font.PLAIN, 14));
	            if (index == 0) {
	                label.setBackground(new Color(255, 215, 0)); // Oro
	            } else if (index == 1) {
	                label.setBackground(new Color(192, 192, 192)); // Plata
	            } else if (index == 2) {
	                label.setBackground(new Color(205, 127, 50)); // Bronce
	            } else {
	                label.setBackground(new Color(240, 240, 240)); // Fondo por defecto
	            }
	            if (isSelected) {
	                label.setBackground(label.getBackground().darker());
	            }
	            return label;
	        }
	    });
	    JScrollPane scrollPane = new JScrollPane(jList);

	    JLabel title = new JLabel("Top 10");
	    title.setFont(new Font("Arial", Font.BOLD, 16));
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(title, BorderLayout.NORTH);

	    jList.setBackground(new Color(240, 240, 240));
	    jList.setFont(new Font("Arial", Font.PLAIN, 14));

	    panel.add(scrollPane, BorderLayout.CENTER);
	    JOptionPane.showMessageDialog(null, panel, "JList en Ventana Emergente", JOptionPane.PLAIN_MESSAGE);
	}
	public void actualizarNuevoJugador(String respuesta) {
		jugadoractual=respuesta;
		panelInferior.actualizarJugador(respuesta);
		
	}

	public void verificarTop10(int puntaje) {
		boolean actualizar=top.esTop10(puntaje);
		if (actualizar) {
			top.agregarRegistro(jugadoractual, puntaje);
		}
		
	}

	public void actualizarjugadas() {
		panelInferior.actualizarJugadas();		
	}

}
