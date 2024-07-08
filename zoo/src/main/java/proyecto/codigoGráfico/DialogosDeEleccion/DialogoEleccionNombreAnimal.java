package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;
import proyecto.codigoInterno.Zoologico;

/**
 * Dialogo que aparece en una nueva vemtama para escribir el nombre del animal entrante
 * @author Ariel Cisternas
 */

public class DialogoEleccionNombreAnimal extends DialogoEleccionNombreBase  {
    /* tipo de animal */
    private String tipo;
    /**
     * Constructor donde se guarda el nombre y tipo del animal en especifico
     * @param ventana ventana en la que aparece
     * @param dialogoanterior el dialogo que se realiza antes de la nueva ventana
     * @param tipo tipo de animal (raza)
     */
    public DialogoEleccionNombreAnimal(JFrame ventana, JDialog dialogoanterior,String tipo){
        super(ventana, dialogoanterior, "Elija el nombre del animal");
        this.tipo = tipo;
    }
    @Override
    /* Metodo donde se acepta el nombre del animal */
    protected void aceptar(){
        Zoologico.getInstance().getHabitatActual().addAnimal(nombre.getText(), tipo);
        this.dispose();
        dialogoanterior.dispose();
    }
}
