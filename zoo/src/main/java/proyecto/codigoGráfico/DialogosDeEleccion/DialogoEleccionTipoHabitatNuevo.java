package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;
import java.awt.*;

/**
 * Clase de seleccion de tipo de Habitat
 * @author Ariel Cisternas
 */

public class DialogoEleccionTipoHabitatNuevo extends JDialog{
    /**
     * Constructor donde se añaden los botones de seleccion de tipo de habitat
     * @param ventana actual
     */
    public DialogoEleccionTipoHabitatNuevo(JFrame ventana){
        super(ventana, "Elija el tipo de habitat", true);
        setLayout(new GridLayout(1, 5));
        setSize(500, 100);
        setLocationRelativeTo(null);
        JButton bosque = new JButton("Bosque");
        JButton artico = new JButton("Artico");
        JButton sabana = new JButton("Sabana");
        JButton selva = new JButton("Selva");
        JButton desierto = new JButton("Desierto");
        bosque.addActionListener(e -> abirDialogo(ventana, "Bosque"));
        artico.addActionListener(e -> abirDialogo(ventana, "Ártico"));
        sabana.addActionListener(e -> abirDialogo(ventana, "Sabana"));
        selva.addActionListener(e -> abirDialogo(ventana, "Selva"));
        desierto.addActionListener(e -> abirDialogo(ventana, "Desierto"));
        add(bosque);
        add(artico);
        add(sabana);
        add(selva);
        add(desierto);
    }
    /**
     * Metodo donde se abre el dialogo para escoger el nombre del habitat
     * @param ventana actual
     * @param tipo de animal
     */
    private void abirDialogo(JFrame ventana, String tipo){
        DialogoEleccionNombreHabitatNuevo elegir = new DialogoEleccionNombreHabitatNuevo(ventana,this, tipo);
        elegir.setVisible(true);
    }
}
