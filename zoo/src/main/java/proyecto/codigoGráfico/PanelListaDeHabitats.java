package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelListaDeHabitats extends JPanel{
    private JLabel habitat;
    private JButton ir;
    public PanelListaDeHabitats(String tipoHabitat, ActionListener listener) {
        setLayout(new BorderLayout());
        habitat = new JLabel(tipoHabitat);
        ir = new JButton("Ir");
        ir.addActionListener(listener);
        add(habitat, BorderLayout.CENTER);
        add(ir, BorderLayout.EAST);
    }
    public JButton getBotonIr() {
        return ir;
    }
}
