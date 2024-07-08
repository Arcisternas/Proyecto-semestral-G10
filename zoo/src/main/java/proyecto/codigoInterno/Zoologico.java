package proyecto.codigoInterno;

import java.util.*;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.Habitats.Habitat;
import proyecto.codigoInterno.Animales.Animal;

public class Zoologico {
    private static Zoologico instance = new Zoologico();
    private List<Habitat> habitats;
    private Habitat habitatActual;
    private int animalId;
    private int popularidad;
    private int carne;
    private int plantas;

    private Zoologico() {
        habitats = new ArrayList<>();
        animalId = 0;
        this.carne = 0;
        this.plantas = 0;
     }
    public static Zoologico getInstance() {
        return instance;
    }
    public void addHabitat(String nombre, String tipoHabitat) {
        habitats.add(FabricaDeHabitats.crearHabitat(nombre, tipoHabitat));
        if(habitats.size() == 1){
            habitatActual = habitats.get(0);
        }
        actualizarPopularidad();
        PanelHabitat.getInstance().actualizarFondoPanel();
    }
    public List<Habitat> getHabitats(){
        return habitats;
    }
    public void setHabitatActual(Habitat actual) {
        habitatActual = actual;
    }
    public Habitat getHabitatActual() {
        return habitatActual;
    }
    public int getAnimalId(){
        return animalId;
    }
    public void aumentarAnimalId(){
        animalId++;
    }
    public int getPopularidad(){
        return popularidad;
    }
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
    public int getCarne(){
        return carne;
    }
    public int getPlanta(){
        return plantas;
    }
    public void aumentarCarne(){
        carne++;
    }
    public void reducirCarne(){
        carne--;
    }
    public void aumenarPlanta(){
        plantas++;
    }
    public void reducirPlanta(){
        plantas--;
    }
    public boolean suficienteCarne(){
        if(carne>0){
            return true;
        }else{
            return false;
        }
    }
    public boolean suficientePlanta(){
        if(plantas>0){
            return true;
        }else{
            return false;
        }
    }
}
