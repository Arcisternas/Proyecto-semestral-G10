package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;
import java.awt.*;

public abstract class DialogoListaBase extends JDialog{
    protected JPanel panelscroll;
    protected JScrollPane scroll;
    protected JButton botonPrincipal;
    protected JPanel panelBoton;
    public DialogoListaBase(JFrame ventana, String titulo, String textoBoton) {
        super(ventana, titulo, true);
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(ventana);

        panelscroll = new JPanel();
        panelscroll.setLayout(new BoxLayout(panelscroll, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(panelscroll);
        add(scroll, BorderLayout.CENTER);

        botonPrincipal = new JButton(textoBoton);
        panelBoton = new JPanel();
        panelBoton.add(botonPrincipal);
        add(panelBoton, BorderLayout.SOUTH);

        botonPrincipal.addActionListener(e -> accionBotonPrincipal(ventana));
    }

    protected abstract void accionBotonPrincipal(JFrame ventana);

    protected abstract void actualizarPanelScroll();
}

