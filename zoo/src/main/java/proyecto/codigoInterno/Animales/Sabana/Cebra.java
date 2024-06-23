package proyecto.codigoInterno.Animales.Sabana;

import proyecto.codigoInterno.Animales.Animal;

public class Cebra extends Animal{
    public Cebra(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Cebra";
    }
    public String getHabitat(){
        return "Sabana";
    }
}
