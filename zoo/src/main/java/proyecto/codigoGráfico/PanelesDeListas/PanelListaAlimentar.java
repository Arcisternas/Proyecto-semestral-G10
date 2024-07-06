package proyecto.codigoGráfico.PanelesDeListas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import proyecto.codigoInterno.Animales.*;


public class PanelListaAlimentar extends JPanel {
    private JLabel etiquetaHabitat;
    private String texto;
    private JButton alimentar;
    public PanelListaAlimentar(Animal animal, ActionListener listener) {
        setLayout(new BorderLayout());
        texto = animal.getNombre()+" ("+animal.getEspecie()+")  " + "  Animo: " + animal.getAnimo();
        etiquetaHabitat = new JLabel(texto);
        alimentar = new JButton("Alimentar");
        alimentar.addActionListener(listener);
        add(alimentar, BorderLayout.EAST);
        add(etiquetaHabitat, BorderLayout.CENTER);
    }
}