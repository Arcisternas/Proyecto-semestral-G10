package proyecto.codigoInterno.Habitats;

import java.util.*;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.FabricaDeAnimales;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.*;

public abstract class Habitat {
    private String nombre;
    private Zoologico zoo = Zoologico.getInstance();
    protected List<Animal> animales;
    public Habitat(String nombre){
        this.nombre = nombre;
        animales = new ArrayList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public List<Animal> getAnimales(){
        return animales;
    }
    public void addAnimal(String nombre, String tipo){
        if (animalesPermitidos().contains(tipo)){
        Animal animal = (FabricaDeAnimales.crearAnimal(nombre,zoo.getAnimalId(),tipo));
        animal.setHabitatActualAnimal(this);
        zoo.aumentarAnimalId();
        animales.add(animal);
        animal.pedirComida(zoo.getHabitatActual());
        actualizarAnimoAnimales();
        PanelHabitat.getInstance().añadirImagenAnimalPanel(animal);
        }
        else{
            System.out.println("No se puede agregar este animal al habitat");
        }
    }
    public void actualizarAnimoAnimales(){
        for (Animal animal : animales) {
            animal.calcularAnimoSegunCompañeros();
        }
        zoo.actualizarPopularidad();
        PanelHabitat.getInstance().actualizarPopularidadLabel();
    }
    public void alimentarAnimales() {
        for (Animal animal : animales) {
            animal.comer();  // Alimentar a cada animal en el hábitat
        }
    }
    public void eliminarAnimal(Animal animal){
        animales.remove(animal);
    }
    public abstract String getTipo();
    public abstract List<String> animalesPermitidos();
}
