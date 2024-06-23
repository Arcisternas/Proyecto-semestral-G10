package proyecto.codigoInterno.Animales.Desierto;

import proyecto.codigoInterno.Animales.Animal;

public class Escorpion extends Animal{
    public Escorpion(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Escorpión";
    }
    public String getHabitat(){
        return "Desierto";
    }
}
