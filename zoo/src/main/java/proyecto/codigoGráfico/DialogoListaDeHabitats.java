package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Habitats.Habitat;

public class DialogoListaDeHabitats extends JDialog {
    private Zoologico zoo;
    private JPanel panelscroll;
    private JScrollPane scroll;
    private JButton crearHabitat;
    private JPanel panelBoton;
    public DialogoListaDeHabitats(JFrame ventana) {
        super(ventana, "Lista de Habitats", false);
        setLayout(new BorderLayout());
        setSize(400, 300);
        zoo = Zoologico.getInstance();
        panelscroll = new JPanel();
        panelscroll.setLayout(new BoxLayout(panelscroll, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(panelscroll);
        add(scroll, BorderLayout.CENTER);
        crearHabitat = new JButton("Crear Habitat");
        crearHabitat.addActionListener(e -> abrirDialogo(ventana));
        panelBoton = new JPanel();
        panelBoton.add(crearHabitat);
        add(panelBoton, BorderLayout.SOUTH);
        actualizarPanelScroll();
    }

    private void actualizarPanelScroll() {
        panelscroll.removeAll();
        for (Habitat habitat : zoo.getHabitats()) {
            PanelListaDeHabitats panel = new PanelListaDeHabitats(habitat, e-> irHabitat(habitat));
            panelscroll.add(panel);
        }   
    }

    private void irHabitat(Habitat habitat) { 
        JOptionPane.showMessageDialog(this, "Yendo al hábitat: " + habitat.getNombre());
        Zoologico.getInstance().setHabitatActual(habitat);
        PanelHabitat.getInstance().actualizarimagen();
        this.dispose();
    }
    private void abrirDialogo(JFrame ventana) {
        DialogoEleccionTipoHabitatNuevo elegir = new DialogoEleccionTipoHabitatNuevo(ventana);
        elegir.setVisible(true);
        this.dispose();
    }
}
