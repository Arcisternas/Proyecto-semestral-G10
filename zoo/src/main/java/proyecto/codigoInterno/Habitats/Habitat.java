package proyecto.codigoInterno.Habitats;

import java.util.*;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.FabricaDeAnimales;
import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.*;

/**
 * Clase de habitat en el cual residen los animales (se definira solo este ya que el resto de habitats usan esta clase abstracta)
 * @author Ariel Cisternas
 * @author Maria Jesus Olivares
 */

public abstract class Habitat {
    private String nombre;  //nombre del habitat
    private Zoologico zoo = Zoologico.getInstance(); //instancia del zoologic
    protected List<Animal> animales; //lista de animales
    /**
     * Constructor donde se determina el nombre de este y los animales que estaran en este
     * @param nombre del habitat
     */
    public Habitat(String nombre){
        this.nombre = nombre;
        animales = new ArrayList<>();
    }
    /**
     * Metodo que retorna el nombre del habitat
     * @return String nombre del habitat
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Metodo que retorna la lista de animales en el habitat
     * @return Lista de animales
     */
    public List<Animal> getAnimales(){
        return animales;
    }
    /**
     * Metodo en el cual se pueden añadir animales al habitat
     * @param nombre del animal
     * @param tipo del animal
     */
    public void addAnimal(String nombre, String tipo){
        if (animalesPermitidos().contains(tipo)){   //existen animales permitidos para cada habitat 
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
    /**
     * metodo donde se actualiza el animo de los animales segun los compañeros de habitat
     */
    public void actualizarAnimoAnimales(){
        for (Animal animal : animales) {
            animal.calcularAnimoSegunCompañeros();
        }
        zoo.actualizarPopularidad();
        PanelHabitat.getInstance().actualizarPopularidadLabel();
    }
    /**
     * metodo para alimentar a los animales en el habitat
     */
    public void alimentarAnimales() {
        for (Animal animal : animales) {
            animal.comer();  // Alimentar a cada animal en el hábitat
        }
    }
    /**
     * metodo para eliminara los animales del habitat
     * @param animal animal a eliminar
     */
    public void eliminarAnimal(Animal animal){
        animales.remove(animal);
    }
    public abstract String getTipo();   //retorna el tipo del habitat (sabana, bosque, etc)
    public abstract List<String> animalesPermitidos(); //retona los animales permitidos por cada habitat
}
