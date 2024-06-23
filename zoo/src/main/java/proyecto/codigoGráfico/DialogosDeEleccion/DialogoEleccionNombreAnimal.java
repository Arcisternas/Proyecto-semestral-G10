package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;

public class DialogoEleccionNombreAnimal extends DialogoEleccionNombreBase  {
    private String tipo;
    public DialogoEleccionNombreAnimal(JFrame ventana, JDialog dialogoanterior,String tipo){
        super(ventana, dialogoanterior, "Elija el nombre del animal");
        this.tipo = tipo;
    }
    @Override
    protected void aceptar(){
        Zoologico.getInstance().getHabitatActual().addAnimal(nombre.getText(), tipo);
        this.dispose();
        dialogoanterior.dispose();
    }
}
