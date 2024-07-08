package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;
import java.awt.*;

import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaAlimentar;

/**
 * Clase donde se puede alimentar al animal y añadir comida
 *  @author Maria Jesus Olivares
 */
public class DialogoListaAlimentar extends DialogoListaBase {
    private Habitat habitat; //habitat actual
    private JButton segundoBoton; // existen 2 botones, la base solo trae uno, asi que se agrega otro

    /**
     * Constructor donde se visualiza los dialogos de la ventana de seleccion de acciones a realizar
     * @param ventana actual
     */
    public DialogoListaAlimentar(JFrame ventana) {
        super(ventana, "Lista de Animales a Alimentar", "Agregar Plantas");
        habitat = Zoologico.getInstance().getHabitatActual();
        segundoBoton = new JButton("Agregar Carne");
        panelBoton.add(segundoBoton,BorderLayout.EAST);
        segundoBoton.addActionListener(e -> accionSegundoBoton(ventana));
        
        actualizarPanelScroll();
    }
    /**
     * Este boton aumenta las plantas en el habitat (comida)
     * @param ventana actual
     */
    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
        Zoologico.getInstance().aumenarPlanta();
        actualizarPanelScroll();
    }
    /**
     * Metodo que actualiza el panel
     */
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
    /**
     * Este boton aumenta la carne en el habitat (comida)
     * @param ventana actual
     */
    private void accionSegundoBoton(JFrame ventana){
        //boton derecha
        Zoologico.getInstance().aumentarCarne();
        actualizarPanelScroll();
    }
    /**
     * Metodo donde se puede alimentar al animal
     * @param animal
     */
    private void Alimentar(Animal animal) {
        String dieta = animal.getDieta();
        if(Zoologico.getInstance().suficientePlanta() && dieta == "Herbivoro"){//si hay suficiente comida y es herbivoro, come
            JOptionPane.showMessageDialog(this, "Alimentando al animal: " + animal.getNombre() + " (" + animal.getEspecie() + ")");
            animal.comer();
            Zoologico.getInstance().reducirPlanta();
        }else if(Zoologico.getInstance().suficienteCarne() && dieta == "Carnivoro"){//si hay suficiente comida y es carnivoro, come
            JOptionPane.showMessageDialog(this, "Alimentando al animal: " + animal.getNombre() + " (" + animal.getEspecie() + ")");
            animal.comer();
            Zoologico.getInstance().reducirCarne();
        }else{ //si no, no come porque no hay suficiente comida de su tipo de dieta 
            JOptionPane.showMessageDialog(this, "No hay comida suficiente para " + animal.getNombre() + " (" + animal.getEspecie() + ")");
        }
       
        actualizarPanelScroll();
        this.dispose();
    }
}
