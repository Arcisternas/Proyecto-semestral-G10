package proyecto.codigoInterno.Habitats;

import java.util.*;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.FabricaDeAnimales;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.*;

public abstract class Habitat {
    private String nombre;
    protected List<Animal> animales;
    protected List<String> tipoAnimales;
    private Zoologico zoo = Zoologico.getInstance();
    public Habitat(String nombre){
        this.nombre = nombre;
        animales = new ArrayList<>();
        tipoAnimales = new ArrayList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public abstract String getTipo();
    public List<Animal> getAnimales(){
        return animales;
    }
    public List<String> getTipoAnimales(){
        return tipoAnimales;
    }
    public void addAnimal(String nombre, String tipo){
        if (animalesPermitidos().contains(tipo)){
        Animal animal = (FabricaDeAnimales.crearAnimal(nombre,zoo.getAnimalId(),tipo));
        animal.setHabitatActualAnimal(this);
        zoo.aumentarAnimalId();
        animales.add(animal);
        tipoAnimales.add(tipo); //Revisar si se usa en alguna parte
        animal.pedirComida(zoo.getHabitatActual());
        for (Animal animalEnHabitat : animales) {
            animalEnHabitat.calcularAnimoSegunCompañeros();
        }
        PanelHabitat.getInstance().añadirImagenAnimalPanel(animal);
        }
        else{
            System.out.println("No se puede agregar este animal al habitat");
        }
    }
    public void alimentarAnimales() {
        for (Animal animal : animales) {
            animal.comer();  // Alimentar a cada animal en el hábitat
        }
    }
    public void eliminarAnimal(Animal animal){
        animales.remove(animal);
    }
    public abstract List<String> animalesPermitidos();
}
