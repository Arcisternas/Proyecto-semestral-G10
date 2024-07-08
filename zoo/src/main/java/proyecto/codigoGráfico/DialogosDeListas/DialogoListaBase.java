package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;
import java.awt.*;

/**
 * Clase Abstracta que funciona como base para el resto de Dialogos de lista
 * @author Ariel Cisternas
 */

public abstract class DialogoListaBase extends JDialog{
    protected JPanel panelscroll;
    protected JScrollPane scroll;
    protected JButton botonPrincipal;
    protected JPanel panelBoton;

    /**
     * Constructor del dialogo de lista, donde se establece el tamaño de la ventana emergente y sus botones
     * @param ventana emergente
     * @param titulo de la ventana
     * @param textoBoton texto del boton a crear
     */
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
    /**
     * Metodo donde se escribiran las acciones del boton principal
     * @param ventana actual
     */
    protected abstract void accionBotonPrincipal(JFrame ventana);
    /**
     * Metodo donde se escribiran la forma de actualizar el panel
     */
    protected abstract void actualizarPanelScroll();
}

