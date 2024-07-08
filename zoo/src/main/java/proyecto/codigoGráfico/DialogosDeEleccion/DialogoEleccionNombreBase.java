package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;
import java.awt.*;

/**
 * Clase abstracta que es la base de ciertas ventanas de creacion
 * @author Ariel Cisternas
 */

public abstract class DialogoEleccionNombreBase extends JDialog{
    /*datos para el nombre a ingresar y el dialogo anterior a la ventana */
    protected JTextField nombre;
    protected JDialog dialogoanterior;

    /**
     * Constructor para la seleccion de nombre (habitat/animal)
     * @param ventana actual
     * @param dialogoanterior dialogo pasado 
     * @param titulo tipo de animal o habitat
     */
    public DialogoEleccionNombreBase(JFrame ventana, JDialog dialogoanterior, String titulo){
        super(ventana, titulo, true);
        this.dialogoanterior = dialogoanterior;
        setLayout(new BorderLayout());
        setSize(300, 100);
        setLocationRelativeTo(null);
        nombre = new JTextField();
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(e -> aceptar()); //se añade un boton para aceptar el nombre ingresado
        add(nombre, BorderLayout.CENTER);
        add(aceptar, BorderLayout.SOUTH);
    }
    /* Metodo donde se aceptan los cambios o creacion segun corresponda (ejemplo, ingresar el nombre del habitat o animal) */
    protected abstract void aceptar();
}
