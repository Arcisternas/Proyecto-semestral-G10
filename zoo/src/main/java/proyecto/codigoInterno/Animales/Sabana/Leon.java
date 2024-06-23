package proyecto.codigoInterno.Animales.Sabana;

import proyecto.codigoInterno.Animales.Animal;

public class Leon extends Animal{
    public Leon(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "León";
    }
    public String getHabitat(){
        return "Sabana";
    }
}
