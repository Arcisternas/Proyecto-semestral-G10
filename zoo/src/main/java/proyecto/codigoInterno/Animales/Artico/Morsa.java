package proyecto.codigoInterno.Animales.Artico;

import proyecto.codigoInterno.Animales.Animal;

public class Morsa extends Animal{
    public Morsa(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Morsa";
    }
    public String getHabitat(){
        return "Artico";
    }
}
