package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;
/**
 * Clase donde se ingresa el nombre del habitat
 * @author Ariel Cisternas
 */
public class DialogoEleccionNombreHabitatNuevo extends DialogoEleccionNombreBase{
    private String tipoHabitat;
    /**
     * Constructor donde se guarda el nombre y tipo de habitat
     * @param ventana actual
     * @param dialogoanterior dialogo pasado
     * @param tipoHabitat tipo del habitat actual
     */
    public DialogoEleccionNombreHabitatNuevo(JFrame ventana,JDialog dialogoanterior, String tipoHabitat){
        super(ventana,dialogoanterior,"Elija el nombre de habitat");
        this.tipoHabitat = tipoHabitat;
    }
    @Override
    protected void aceptar (){
        Zoologico.getInstance().addHabitat(nombre.getText(), tipoHabitat);
        this.dispose();
        dialogoanterior.dispose();
    }
}
