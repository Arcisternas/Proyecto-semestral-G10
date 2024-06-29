package proyecto.codigoInterno.Habitats;

import java.util.*;

import javax.swing.ImageIcon;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.FabricaDeAnimales;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.*;

public abstract class Habitat {
    private String nombre;
    protected List<Animal> animales;
    protected List<String> tipoAnimales;
    private Zoologico zoo = Zoologico.getInstance();
    private List<ImageIcon> imagenesAnimales = new ArrayList<>();
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
    public List<ImageIcon> getImagenesAnimales(){
        return imagenesAnimales;
    }
    public void addAnimal(String nombre, String tipo){
        if (animalesPermitidos().contains(tipo)){
        Animal animal = (FabricaDeAnimales.crearAnimal(nombre,tipo));
        animales.add(animal);
        tipoAnimales.add(tipo);
        animal.pedirComida(zoo.getHabitatActual());
        imagenesAnimales.add(animal.getImagenIcon());
        }
        else{
            System.out.println("No se puede agregar este animal al habitat");
        }
        PanelHabitat.getInstance().actualizarimagen();
    }
    public void addImagenAnimal(ImageIcon imagen){
        imagenesAnimales.add(imagen);
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
