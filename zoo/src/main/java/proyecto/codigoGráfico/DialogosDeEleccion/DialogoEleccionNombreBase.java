package proyecto.codigoGráfico.DialogosDeEleccion;

import javax.swing.*;
import java.awt.*;

public abstract class DialogoEleccionNombreBase extends JDialog{

    protected JTextField nombre;
    protected JDialog dialogoanterior;

    public DialogoEleccionNombreBase(JFrame ventana, JDialog dialogoanterior, String titulo){
        super(ventana, titulo, true);
        this.dialogoanterior = dialogoanterior;
        setLayout(new BorderLayout());
        setSize(300, 100);
        setLocationRelativeTo(null);
        nombre = new JTextField();
        JButton aceptar = new JButton("Aceptar");
        aceptar.addActionListener(e -> aceptar());
        add(nombre, BorderLayout.CENTER);
        add(aceptar, BorderLayout.SOUTH);
    }

    protected abstract void aceptar();
}
