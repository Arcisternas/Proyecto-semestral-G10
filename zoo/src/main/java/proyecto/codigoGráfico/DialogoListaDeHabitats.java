package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Habitats.Habitat;

public class DialogoListaDeHabitats extends JDialog {
    private Zoologico zoo;
    private DefaultListModel<String> listaModelo;
    private JList<String> listaHabitats;
    private JScrollPane scroll;
    private JButton crearHabitat;
    private JPanel panelBoton;
    public DialogoListaDeHabitats(JFrame ventana) {
        super(ventana, "Lista de Habitats", true);
        setLayout(new BorderLayout());
        setSize(400, 300);
        zoo = Zoologico.getInstance();
        listaModelo = new DefaultListModel<>();
        listaHabitats = new JList<>(listaModelo);
        actualizarListaHabitats();
        scroll = new JScrollPane(listaHabitats);
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
    }

    private void actualizarListaHabitats() {
        listaModelo.clear();
        for (Habitat habitat : zoo.getHabitats()) {
            listaModelo.addElement(habitat.getTipo());
        }   
    }

    private void irHabitat(String tipohabitat) {
        //Pendiente, cambiar fondo a hábitat seleccionado y cerrar dialogo
        JOptionPane.showMessageDialog(this, "Yendo al hábitat: " + tipohabitat);
        System.out.println("Ir a " + tipohabitat);
    }
}
