package proyecto.codigoInterno.Animales.Bosque;

import proyecto.codigoInterno.Animales.Animal;

public class Zorro extends Animal{
    public Zorro(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Zorro";
    }
    public String getHabitat(){
        return "Bosque";
    }
}
