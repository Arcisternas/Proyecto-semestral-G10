package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoGráfico.DialogosDeEleccion.*;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaDeHabitats;;

public class DialogoListaDeHabitats extends DialogoListaBase {
    private Zoologico zoo;

    public DialogoListaDeHabitats(JFrame ventana) {
        super(ventana, "Lista de Habitats", "Crear Habitat");
        zoo = Zoologico.getInstance();
        actualizarPanelScroll();
    }

    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
        DialogoEleccionTipoHabitatNuevo elegir = new DialogoEleccionTipoHabitatNuevo(ventana);
        elegir.setVisible(true);
        actualizarPanelScroll();
    }

    @Override
    protected void actualizarPanelScroll() {
        panelscroll.removeAll();
        for (Habitat habitat : zoo.getHabitats()) {
            PanelListaDeHabitats panel = new PanelListaDeHabitats(habitat, e -> irHabitat(habitat));
            panelscroll.add(panel);
        }
        this.revalidate();
    }

    private void irHabitat(Habitat habitat) {
        JOptionPane.showMessageDialog(this, "Yendo al hábitat: " + habitat.getNombre());
        Zoologico.getInstance().setHabitatActual(habitat);
        PanelHabitat.getInstance().actualizarimagen();
        this.dispose();
    }
}