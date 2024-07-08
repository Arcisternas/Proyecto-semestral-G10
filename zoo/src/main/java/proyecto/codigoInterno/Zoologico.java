package proyecto.codigoInterno;

import java.util.*;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoInterno.Animales.Animal;

/**
 * Clase de Zoologico (donde se concentran habitats y animales)
 * @author Ariel Cisternas
 * @author Maria Jesus Olivares
 */

public class Zoologico {
    private static Zoologico instance = new Zoologico(); //instancia propia
    private List<Habitat> habitats; //listado de habitats
    private Habitat habitatActual; //habitat actual
    private int animalId; //id de un animal
    private int popularidad; //popularidad del zoologico
    private int carne; //cuanta carne tiene el habitat
    private int plantas; //cuantas plantas tiene el habitat

    /**
     * Constructor donde se definen ciertas variables
     */
    private Zoologico() {
        habitats = new ArrayList<>();
        animalId = 0;
        this.carne = 0;
        this.plantas = 0;
     }
    /**
     * Metodo estatico de instancia del zoologico
     * @return
     */
    public static Zoologico getInstance() {
        return instance;
    }
    /**
     * Metodo para añadir habitats al listado del zoologico
     * @param nombre nombre del habitat
     * @param tipoHabitat tipo de habitat
     */
    public void addHabitat(String nombre, String tipoHabitat) {
        habitats.add(FabricaDeHabitats.crearHabitat(nombre, tipoHabitat));
        if(habitats.size() == 1){
            habitatActual = habitats.get(0);
        }
        actualizarPopularidad();
        PanelHabitat.getInstance().actualizarFondoPanel();
    }
    /**
     * Metodo para recuperar el listado de habitats
     * @return listado de habitats
     */
    public List<Habitat> getHabitats(){
        return habitats;
    }
    /**
     * metodo para seleccionar el habitat actual
     * @param actual habitat actual
     */
    public void setHabitatActual(Habitat actual) {
        habitatActual = actual;
    }
    /**
     *metodo para recuperar el habitat actual
     * @return habitat actual
     */
    public Habitat getHabitatActual() {
        return habitatActual;
    }
    /**
     * metodo para recuperar el id del animal en habitat
     * @return int animal id
     */
    public int getAnimalId(){
        return animalId;
    }
    /**
     * metodo para aumentar el id del animal en habitat
     */
    public void aumentarAnimalId(){
        animalId++;
    }
    /**
     * metodo para recuperar la popularidad actual del habitat
     * @return int popularidad
     */
    public int getPopularidad(){
        return popularidad;
    }
    /**
     * metodo para actualizar la popularidad del habitat
     */
    public void actualizarPopularidad(){
        popularidad = 0;
        for (Habitat habitat : habitats) {
            for (Animal animal : habitat.getAnimales()) {
                popularidad += animal.getAnimo();
            }
            popularidad += 5;
        }
        PanelHabitat.getInstance().actualizarPopularidadLabel();
    }
    /**
     * metodo para recuperar la cantidad de carne en habitat
     * @return int carne
     */
    public int getCarne(){
        return carne;
    }
    /**
     * metodo para recuperar la cantidad de plantas en habitat
     * @return int plantas
     */
    public int getPlanta(){
        return plantas;
    }
    /** metodo para aumentar la carna */
    public void aumentarCarne(){
        carne++;
    }
    /**metodo para reducir la carne */
    public void reducirCarne(){
        carne--;
    }
    /**metodo para aumentar las plantas */
    public void aumenarPlanta(){
        plantas++;
    }
    /**metodo paara reducir las plantas */
    public void reducirPlanta(){
        plantas--;
    }
    /**
     * metodo que retorna true o false segun la cantidad de carne
     * @return true si hay carne, false si no hay
     */
    public boolean suficienteCarne(){
        if(carne>0){
            return true;
        }else{
            return false;
        }
    }
    /**
     * metodo que retorna si hay plantas suficientes
     * @return true si hay plantas, false si no hay
     */
    public boolean suficientePlanta(){
        if(plantas>0){
            return true;
        }else{
            return false;
        }
    }
}
