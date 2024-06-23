package proyecto.codigoInterno.Animales.Desierto;

import proyecto.codigoInterno.Animales.Animal;

public class Cobra extends Animal{
    public Cobra(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Cobra";
    }
    public String getHabitat(){
        return "Desierto";
    }
}
