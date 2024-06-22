package proyecto.codigoInterno.Habitats;

import java.util.*;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Animales.Selva.*;

public class Selva extends Habitat{
    public Selva(String nombre){
        super(nombre);
    }
    public String getTipo(){
        return "Selva";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Tigre","Mono","Serpiente","Tucán");
        return permitidos;
    }
}
