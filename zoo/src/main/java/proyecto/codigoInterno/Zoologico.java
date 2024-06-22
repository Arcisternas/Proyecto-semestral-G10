package proyecto.codigoInterno;

import java.util.*;

import proyecto.codigoInterno.Habitats.Habitat;
//Nota: El profesor dijo que quizá no sea necesario implementar el patrón Singleton en esta clase
public class Zoologico {
    private static Zoologico instance = new Zoologico();
    private List<Habitat> habitats;
    private List<String> nombreHabitats;
    private Habitat habitatActual;
    private Zoologico() {
        habitats = new ArrayList<>();
        nombreHabitats = new ArrayList<>();
     }
    public static Zoologico getInstance() {
        return instance;
    }
    public void addHabitat(String nombre, String tipoHabitat) {
        habitats.add(FrabricaDeHabitats.crearHabitat(nombre, tipoHabitat));
        nombreHabitats.add(nombre);
    }
    public List<Habitat> getHabitats(){
        return habitats;
    }
    public List<String> getNombreHabitats(){
        return nombreHabitats;
    }
    public void setHabitatActual(Habitat actual) {
        habitatActual = actual;
    }
    public Habitat getHabitatActual() {
        return habitatActual;
    }
}
