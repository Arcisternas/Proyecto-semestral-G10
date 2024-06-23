package proyecto.codigoGráfico.PanelesDeListas;

import javax.swing.*;
import java.awt.*;

import proyecto.codigoInterno.Animales.*;

public class PanelListaDeAnimales extends JPanel {
    private JLabel etiquetaHabitat;
    private String texto;
    public PanelListaDeAnimales(Animal animal) {
        setLayout(new BorderLayout());
        texto = animal.getNombre()+" ("+animal.getEspecie()+")";
        etiquetaHabitat = new JLabel(texto);
        add(etiquetaHabitat, BorderLayout.CENTER);
    }
}
