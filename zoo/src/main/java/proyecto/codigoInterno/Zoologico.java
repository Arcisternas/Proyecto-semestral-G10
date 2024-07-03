package proyecto.codigoInterno;

import java.util.*;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.Habitats.Habitat;
//Nota: El profesor dijo que quizá no sea necesario implementar el patrón Singleton en esta clase
public class Zoologico {
    private static Zoologico instance = new Zoologico();
    private List<Habitat> habitats;
    private Habitat habitatActual;
    private int animalId;
    private Zoologico() {
        habitats = new ArrayList<>();
        animalId = 0;
     }
    public static Zoologico getInstance() {
        return instance;
    }
    public void addHabitat(String nombre, String tipoHabitat) {
        habitats.add(FrabricaDeHabitats.crearHabitat(nombre, tipoHabitat));
        if(habitats.size() == 1){
            habitatActual = habitats.get(0);
        }
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
}
