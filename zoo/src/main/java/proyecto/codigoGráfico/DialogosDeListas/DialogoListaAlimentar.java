package proyecto.codigoGráfico.DialogosDeListas;

import javax.swing.*;

import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoGráfico.DialogosDeEleccion.DialogoEleccionTipoAnimal;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaAlimentar;
import proyecto.codigoGráfico.PanelesDeListas.PanelListaDeAnimales;

public class DialogoListaAlimentar extends DialogoListaBase {
    private Habitat habitat;

    public DialogoListaAlimentar(JFrame ventana) {
        super(ventana, "Lista de Animales a Alimentar", "Alimentar a todos");
        habitat = Zoologico.getInstance().getHabitatActual();
        actualizarPanelScroll();
    }
    @Override
    protected void accionBotonPrincipal(JFrame ventana) {
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
    private void Alimentar(Animal animal) {
        JOptionPane.showMessageDialog(this, "Alimentando al animal: " + animal.getNombre() + " (" + animal.getEspecie() + ")");
        animal.comer();
        actualizarPanelScroll();
        this.dispose();
    }
}
