package proyecto.codigoInterno.Habitats;

import java.util.*;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Animales.Sabana.*;

public class Sabana extends Habitat{
    public Sabana(){
        super();
    }
    public String getTipo(){
        return "Sabana";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Cebra", "Elefante", "Jirafa", "León");
        return permitidos;
    }
}
