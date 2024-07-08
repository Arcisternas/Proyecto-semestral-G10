package proyecto.codigoGráfico.PanelesDeListas;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Habitats.Habitat;

import java.awt.*;
import java.awt.event.*;

/**
 * Panel donde se listan los habitats creados y su funcion para añadir mas
 * @author Ariel Cisternas
 */

public class PanelListaDeHabitats extends JPanel{
    private JLabel etiquetaHabitat;
    private String texto;
    private JButton ir;

    /**
     * Constructor donde se visualiza el listado con el nombre de cada habitat, tipo y el boton de añadir mas
     * @param habitat   habitat actual
     * @param listener boton
     */
    public PanelListaDeHabitats(Habitat habitat, ActionListener listener) {
        setLayout(new BorderLayout());
        texto = habitat.getNombre()+" ("+habitat.getTipo()+")";
        if (habitat == Zoologico.getInstance().getHabitatActual()) {
            texto += " (Actual)";
        }
        etiquetaHabitat = new JLabel(texto);
        ir = new JButton("Ir");
        ir.addActionListener(listener);
        add(etiquetaHabitat, BorderLayout.CENTER);
        add(ir, BorderLayout.EAST);
    }
}
