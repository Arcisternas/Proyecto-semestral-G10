package proyecto.codigoGráfico.PanelesDeListas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import proyecto.codigoInterno.Animales.*;

/**
 * Panel donde estaran los animales del habitat listados
 * @author Ariel Cisternas
 */

public class PanelListaDeAnimales extends JPanel {
    private JLabel etiquetaHabitat; //actual
    private String texto; //texto sobre el animal
    private JButton sacar; //boton para sacar al animal
    /**
     * Constructor donde se genera el panel listando a los animales
     * @param animal animales listados
     * @param listener boton 
     */
    public PanelListaDeAnimales(Animal animal, ActionListener listener) {
        setLayout(new BorderLayout());
        texto = animal.getNombre()+" ("+animal.getEspecie()+")  " + "  Animo: " + animal.getAnimo();
        etiquetaHabitat = new JLabel(texto);
        sacar = new JButton("Sacar");
        sacar.addActionListener(listener);
        add(sacar, BorderLayout.EAST);
        add(etiquetaHabitat, BorderLayout.CENTER);
    }
}
