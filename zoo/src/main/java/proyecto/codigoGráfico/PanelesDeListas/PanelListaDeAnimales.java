package proyecto.codigoGráfico.PanelesDeListas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import proyecto.codigoInterno.Animales.*;
import proyecto.codigoInterno.Zoologico;


public class PanelListaDeAnimales extends JPanel {
    private JLabel etiquetaHabitat;
    private String texto;
    private JButton sacar;
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
