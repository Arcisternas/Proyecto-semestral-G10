package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

import proyecto.codigoInterno.Zoologico;

public class DialogoEleccionNombreHabitatNuevo extends JDialog{
    private JTextField nombre;
    private JDialog dialogoanterior;
    public DialogoEleccionNombreHabitatNuevo(JFrame ventana,JDialog dialogoanterior, String tipoHabitat){
        super(ventana, "Elegir nombre de habitat", true);
        this.dialogoanterior = dialogoanterior;
        setLayout(new BorderLayout());
        setSize(300, 100);
        setLocationRelativeTo(null);
        nombre = new JTextField();
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(e -> aceptar(tipoHabitat));
        add(nombre, BorderLayout.CENTER );
        add(aceptar, BorderLayout.SOUTH);
    }
    private void aceptar (String tipoHabitat){
        Zoologico.getInstance().addHabitat(nombre.getText(), tipoHabitat);
        this.dispose();
        dialogoanterior.dispose();
    }
}
