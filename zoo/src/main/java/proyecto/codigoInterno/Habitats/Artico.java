package proyecto.codigoInterno.Habitats;

import java.util.*;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Animales.Artico.*;
public class Artico extends Habitat{
    public Artico(){
        super();
    }
    public String getTipo(){
        return "Artico";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Oso polar", "Pingüino", "Foca", "Morsa");
        return permitidos;
    }
}
