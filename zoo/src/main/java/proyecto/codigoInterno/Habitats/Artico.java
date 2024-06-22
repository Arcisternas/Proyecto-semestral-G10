package proyecto.codigoInterno.Habitats;

import java.util.*;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Animales.Artico.*;
public class Artico extends Habitat{
    public Artico(String nombre){
        super(nombre);
    }
    public String getTipo(){
        return "Ártico";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Oso polar", "Pingüino", "Foca", "Morsa");
        return permitidos;
    }
}
