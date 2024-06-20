package proyecto.codigoInterno.Habitats;

import java.util.*;

import proyecto.codigoInterno.Animales.*;

public abstract class Habitat {
    private String tipo;
    protected List<Animal> animales;
    protected List<String> tipoAnimales;
    
    public Habitat(){
        animales = new ArrayList<>();
        tipoAnimales = new ArrayList<>();
    }
    public abstract String getTipo();
    public List<Animal> getAnimales(){
        return animales;
    }
    public List<String> getTipoAnimales(){
        return tipoAnimales;
    }
    public void addAnimal(Animal animal){
        if (animalesPermitidos().contains(animal.getEspecie())){
        animales.add(animal);
        tipoAnimales.add(animal.getEspecie());
        }
        else{
            System.out.println("No se puede agregar este animal al habitat");
        }
    }
    public abstract List<String> animalesPermitidos();
}
