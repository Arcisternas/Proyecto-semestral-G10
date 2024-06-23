package proyecto.codigoInterno.Animales.Selva;

import proyecto.codigoInterno.Animales.Animal;

public class Tucan extends Animal{
    public Tucan(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Tucán";
    }
    public String getHabitat(){
        return "Selva";
    }
}
