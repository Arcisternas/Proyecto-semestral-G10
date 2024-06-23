package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;

import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoGráfico.DialogosDeEleccion.DialogoEleccionTipoAnimal;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaDeAnimales;

public class DialogoListaDeAnimales extends DialogoListaBase {
    private Habitat habitat;

    public DialogoListaDeAnimales(JFrame ventana) {
        super(ventana, "Lista de Animales", "Añadir Animal");
        habitat = Zoologico.getInstance().getHabitatActual();
        actualizarPanelScroll();
    }
    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
        DialogoEleccionTipoAnimal elegir = new DialogoEleccionTipoAnimal(ventana);
        elegir.setVisible(true);
        actualizarPanelScroll();
    }
    @Override
    public void actualizarPanelScroll() {
        panelscroll.removeAll();
        if (habitat != null) {
            for (Animal animal : habitat.getAnimales()) {
                PanelListaDeAnimales panel = new PanelListaDeAnimales(animal);
                panelscroll.add(panel);
            }
        }
        this.revalidate();
    }
}
