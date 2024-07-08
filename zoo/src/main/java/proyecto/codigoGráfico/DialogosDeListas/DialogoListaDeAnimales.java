package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;

import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoGráfico.DialogosDeEleccion.DialogoEleccionTipoAnimal;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaDeAnimales;

/**
 * Clase donde se genera la ventana de animales en el habitat y añadir mas
 * @author Ariel Cisternas
 */

public class DialogoListaDeAnimales extends DialogoListaBase {
    private Habitat habitat;// habitat actual

    /**
     * Constructor donde se genera la ventana
     * @param ventana
     */
    public DialogoListaDeAnimales(JFrame ventana) {
        super(ventana, "Lista de Animales", "Añadir Animal");
        habitat = Zoologico.getInstance().getHabitatActual();
        actualizarPanelScroll();
    }
    /**
     * Metodo donde el boton principal genera la ventana de eleccion de tipo de animal a añadir
     */
    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
        DialogoEleccionTipoAnimal elegir = new DialogoEleccionTipoAnimal(ventana);
        elegir.setVisible(true);
        actualizarPanelScroll();
    }
    /**
     * MEtodo que actualiza el panel
     */
    @Override
    public void actualizarPanelScroll() {
        panelscroll.removeAll();
        if (habitat != null) {
            for (Animal animal : habitat.getAnimales()) {
                PanelListaDeAnimales panel = new PanelListaDeAnimales(animal, e -> sacarAnimal(animal));
                panelscroll.add(panel);
            }
        }
        this.revalidate();
    }
    /**
     * metodo que remueve a un animal a voluntad del usuario
     * @param animal seleccionado
     */
    private void sacarAnimal(Animal animal) {
        JOptionPane.showMessageDialog(this, "Sacando al animal: " + animal.getNombre() + " (" + animal.getEspecie() + ")");
        animal.desaparecer(animal.getHabitatActualAnimal());
        actualizarPanelScroll();
        this.dispose();
    }
}
