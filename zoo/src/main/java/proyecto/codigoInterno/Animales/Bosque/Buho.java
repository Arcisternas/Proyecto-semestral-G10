package proyecto.codigoInterno.Animales.Bosque;

import proyecto.codigoInterno.Animales.Animal;

public class Buho extends Animal {
    public Buho(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Buho";
    }
    public String getHabitat(){
        return "Bosque";
    }
}
