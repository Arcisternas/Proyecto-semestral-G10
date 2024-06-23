package proyecto.codigoInterno.Animales.Selva;

import proyecto.codigoInterno.Animales.Animal;

public class Mono extends Animal{
    public Mono(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Mono";
    }
    public String getHabitat(){
        return "Selva";
    }
}
