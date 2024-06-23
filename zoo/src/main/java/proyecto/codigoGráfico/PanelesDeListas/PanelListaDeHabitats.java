package proyecto.codigoGráfico.PanelesDeListas;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Habitats.Habitat;

import java.awt.*;
import java.awt.event.*;

public class PanelListaDeHabitats extends JPanel{
    private JLabel etiquetaHabitat;
    private String texto;
    private JButton ir;
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
    public JButton getBotonIr() {
        return ir;
    }
}
