package proyecto.codigoInterno.Animales.Bosque;

import proyecto.codigoInterno.Animales.Animal;

public class Ciervo extends Animal {
    public Ciervo(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Ciervo";
    }
    public String getHabitat(){
        return "Bosque";
    }
}
