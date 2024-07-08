package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;

public class DialogoEleccionNombreHabitatNuevo extends DialogoEleccionNombreBase{
    private String tipoHabitat;
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
