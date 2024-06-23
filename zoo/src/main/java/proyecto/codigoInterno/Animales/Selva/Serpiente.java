package proyecto.codigoInterno.Animales.Selva;

import proyecto.codigoInterno.Animales.Animal;

public class Serpiente extends Animal{
    public Serpiente(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Serpiente";
    }
    public String getHabitat(){
        return "Selva";
    }
}
