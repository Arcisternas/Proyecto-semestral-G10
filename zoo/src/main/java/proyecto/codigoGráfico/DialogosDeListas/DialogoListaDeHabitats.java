package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoGráfico.DialogosDeEleccion.*;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaDeHabitats;

/**
 * Clase donde se genera una ventana de los habitats existentes y la posibilidad de añadir mas
 * @author Ariel Cisternas
 */

public class DialogoListaDeHabitats extends DialogoListaBase {
    private Zoologico zoo;
    /**
     * Constructor donde se genera la ventana
     * @param ventana
     */
    public DialogoListaDeHabitats(JFrame ventana) {
        super(ventana, "Lista de Habitats", "Crear Habitat");
        zoo = Zoologico.getInstance();
        actualizarPanelScroll();
    }
    /**
     * Metodo del boton principal el cual genera el dialogo de eleccion del tipo de habitat
     */
    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
        DialogoEleccionTipoHabitatNuevo elegir = new DialogoEleccionTipoHabitatNuevo(ventana);
        elegir.setVisible(true);
        actualizarPanelScroll();
    }
    /**
     * Metodo que actualiza el panel
     */
    @Override
    protected void actualizarPanelScroll() {
        panelscroll.removeAll();
        for (Habitat habitat : zoo.getHabitats()) {
            PanelListaDeHabitats panel = new PanelListaDeHabitats(habitat, e -> irHabitat(habitat));
            panelscroll.add(panel);
        }
        this.revalidate();
    }
    /**
     * Metodo donde se selecciona uno de los habitats creados para "ir" a aquel habitat
     * @param habitat seleccionado
     */
    private void irHabitat(Habitat habitat) {
        JOptionPane.showMessageDialog(this, "Yendo al hábitat: " + habitat.getNombre());
        Zoologico.getInstance().setHabitatActual(habitat);
        PanelHabitat.getInstance().actualizarImagenesPanel();
        this.dispose();
    }
}