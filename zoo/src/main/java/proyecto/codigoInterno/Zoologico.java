package proyecto.codigoInterno;

import java.util.*;

import proyecto.codigoInterno.Habitats.Habitat;
//Nota: El profesor dijo que quizá no sea necesario implementar el patrón Singleton en esta clase
public class Zoologico {
    private static Zoologico instance = new Zoologico();
    private List<Habitat> habitats;
    private List<String> tipoHabitats;
    private Zoologico() {
        habitats = new ArrayList<>();
        tipoHabitats = new ArrayList<>();
     }
    public static Zoologico getInstance() {
        return instance;
    }
    public void addHabitat(Habitat habitat){
        habitats.add(habitat);
        tipoHabitats.add(habitat.getTipo());
    }
    public List<Habitat> getHabitats(){
        return habitats;
    }
    public List<String> getTipoHabitats(){
        return tipoHabitats;
    }
}
