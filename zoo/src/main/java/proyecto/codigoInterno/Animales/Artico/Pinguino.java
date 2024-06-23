package proyecto.codigoInterno.Animales.Artico;

import proyecto.codigoInterno.Animales.Animal;

public class Pinguino extends Animal{
    public Pinguino(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Pingüino";
    }
    public String getHabitat(){
        return "Artico";
    }
}
