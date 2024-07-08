package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;
import java.awt.*;

import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaAlimentar;

public class DialogoListaAlimentar extends DialogoListaBase {
    private Habitat habitat;
    private JButton segundoBoton;
    private int carne;
    private int plantas;
    private boolean suficienteCarne;
    private boolean suficientePlanta;

    public DialogoListaAlimentar(JFrame ventana) {
        super(ventana, "Lista de Animales a Alimentar", "Agregar Plantas");
        habitat = Zoologico.getInstance().getHabitatActual();
        segundoBoton = new JButton("Agregar Carne");
        panelBoton.add(segundoBoton,BorderLayout.EAST);
        segundoBoton.addActionListener(e -> accionSegundoBoton(ventana));
        this.suficienteCarne = false;
        this.suficientePlanta = false;
        this.carne = 0;
        this.plantas = 0;
        actualizarPanelScroll();
    }
    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
        //boton de la izquierda
        plantas++;
        suficientePlanta = true;
        habitat.alimentarAnimales();
        actualizarPanelScroll();
    }
    @Override
    public void actualizarPanelScroll() {
        panelscroll.removeAll();
        if (habitat != null) {
            for (Animal animal : habitat.getAnimales()) {
                PanelListaAlimentar panel = new PanelListaAlimentar(animal, e -> Alimentar(animal));
                panelscroll.add(panel);
            }
        }
        this.revalidate();
    }
    private void accionSegundoBoton(JFrame ventana){
        carne++;
        suficienteCarne = true;
        actualizarPanelScroll();
        //Aqui pones lo que hace el boton de la derecha
    }
    private void Alimentar(Animal animal) {
        if(suficientePlanta || suficienteCarne){
            JOptionPane.showMessageDialog(this, "Alimentando al animal: " + animal.getNombre() + " (" + animal.getEspecie() + ")");
            animal.comer();
        }else{
            JOptionPane.showMessageDialog(this, "No hay comida suficiente para " + animal.getNombre() + " (" + animal.getEspecie() + ")");
        }
       
        actualizarPanelScroll();
        this.dispose();
    }
}
