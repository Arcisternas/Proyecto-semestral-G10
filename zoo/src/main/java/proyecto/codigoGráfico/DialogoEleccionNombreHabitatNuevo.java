package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

import proyecto.codigoInterno.FrabricaDeHabitats;
import proyecto.codigoInterno.Zoologico;

public class DialogoEleccionNombreHabitatNuevo extends JDialog{
    private JTextField nombre;
    public DialogoEleccionNombreHabitatNuevo(JFrame ventana, String tipoHabitat){
        super(ventana, "Elegir nombre de habitat", true);
        setLayout(new BorderLayout());
        setSize(300, 100);
        nombre = new JTextField();
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(e -> aceptar(tipoHabitat));
        add(nombre, BorderLayout.CENTER );
        add(aceptar, BorderLayout.SOUTH);
    }
    private void aceptar (String tipoHabitat){
        Zoologico.getInstance().addHabitat(nombre.getText(), tipoHabitat);
        this.dispose();
    }
}
