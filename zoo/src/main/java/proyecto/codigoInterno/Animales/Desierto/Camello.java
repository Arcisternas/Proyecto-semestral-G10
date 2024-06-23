package proyecto.codigoInterno.Animales.Desierto;

import proyecto.codigoInterno.Animales.Animal;

public class Camello extends Animal{
    public Camello(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Camello";
    }
    public String getHabitat(){
        return "Desierto";
    }
}
