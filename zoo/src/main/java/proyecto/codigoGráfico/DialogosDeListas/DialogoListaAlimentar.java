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

    public DialogoListaAlimentar(JFrame ventana) {
        super(ventana, "Lista de Animales a Alimentar", "Botón de la izquierda");
        habitat = Zoologico.getInstance().getHabitatActual();
        segundoBoton = new JButton("Botón de la derecha");
        panelBoton.add(segundoBoton,BorderLayout.EAST);
        actualizarPanelScroll();
    }
    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
        //boton de la izquierda
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
        //Aqui pones lo que hace el boton de la derecha
    }
    private void Alimentar(Animal animal) {
        JOptionPane.showMessageDialog(this, "Alimentando al animal: " + animal.getNombre() + " (" + animal.getEspecie() + ")");
        animal.comer();
        actualizarPanelScroll();
        this.dispose();
    }
}
