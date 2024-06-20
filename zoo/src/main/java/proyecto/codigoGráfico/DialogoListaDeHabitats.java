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
        super(ventana, "Lista de Habitats", true);
        setLayout(new BorderLayout());
        setSize(400, 300);
        zoo = Zoologico.getInstance();
        panelscroll = new JPanel();
        panelscroll.setLayout(new BoxLayout(panelscroll, BoxLayout.Y_AXIS));
        scroll = new JScrollPane(panelscroll);
        add(scroll, BorderLayout.CENTER);
        crearHabitat = new JButton("Crear Habitat");
        crearHabitat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Pendiente, añadir nueva ventana de selección de tipo de habitat
            }
        });
        panelBoton = new JPanel();
        panelBoton.add(crearHabitat);
        add(panelBoton, BorderLayout.SOUTH);
        actualizarListaHabitats();
    }

    private void actualizarListaHabitats() {
        panelscroll.removeAll();
        for (Habitat habitat : zoo.getHabitats()) {
            PanelListaDeHabitats panel = new PanelListaDeHabitats(habitat.getTipo(), e->irHabitat(habitat.getTipo()));
            panelscroll.add(panel);
        }   
    }

    private void irHabitat(String tipohabitat) { 
        //Pendiente, cambiar fondo a hábitat seleccionado
        JOptionPane.showMessageDialog(this, "Yendo al hábitat: " + tipohabitat);
        this.dispose();
    }
}
