package proyecto.codigoGráfico;

import javax.swing.*;

import proyecto.codigoInterno.Habitats.Habitat;

import java.awt.*;
import java.awt.event.*;

public class PanelListaDeHabitats extends JPanel{
    private JLabel etiquetaHabitat;
    private JButton ir;
    public PanelListaDeHabitats(Habitat habitat, ActionListener listener) {
        setLayout(new BorderLayout());
        etiquetaHabitat = new JLabel(habitat.getNombre()+" ("+habitat.getTipo()+")");
        ir = new JButton("Ir");
        ir.addActionListener(listener);
        add(etiquetaHabitat, BorderLayout.CENTER);
        add(ir, BorderLayout.EAST);
    }
    public JButton getBotonIr() {
        return ir;
    }
}
