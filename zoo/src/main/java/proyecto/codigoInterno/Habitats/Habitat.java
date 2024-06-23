package proyecto.codigoInterno.Habitats;

import java.util.*;

import proyecto.codigoInterno.FabricaDeAnimales;
import proyecto.codigoInterno.Animales.*;

public abstract class Habitat {
    private String nombre;
    protected List<Animal> animales;
    protected List<String> tipoAnimales;
    
    public Habitat(String nombre){
        this.nombre = nombre;
        animales = new ArrayList<>();
        tipoAnimales = new ArrayList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public abstract String getTipo();
    public List<Animal> getAnimales(){
        return animales;
    }
    public List<String> getTipoAnimales(){
        return tipoAnimales;
    }
    public void addAnimal(String nombre, String tipo){
        if (animalesPermitidos().contains(tipo)){
        animales.add(FabricaDeAnimales.crearAnimal(nombre,tipo));
        tipoAnimales.add(tipo);
        }
        else{
            System.out.println("No se puede agregar este animal al habitat");
        }
    }
    public abstract List<String> animalesPermitidos();
}
