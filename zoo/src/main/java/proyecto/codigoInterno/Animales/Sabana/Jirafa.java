package proyecto.codigoInterno.Animales.Sabana;

import proyecto.codigoInterno.Animales.Animal;

public class Jirafa extends Animal{
    public Jirafa(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Jirafa";
    }
    public String getHabitat(){
        return "Sabana";
    }
}
