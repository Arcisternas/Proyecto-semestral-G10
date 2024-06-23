package proyecto.codigoInterno.Animales.Bosque;

import proyecto.codigoInterno.Animales.Animal;
public class Lobo extends Animal{
    public Lobo(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Lobo";
    }
    public String getHabitat(){
        return "Bosque";
    }
}
