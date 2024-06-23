package proyecto.codigoInterno.Animales.Sabana;

import proyecto.codigoInterno.Animales.Animal;

public class Elefante extends Animal {
    public Elefante(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Elefante";
    }
    public String getHabitat(){
        return "Sabana";
    }
}
