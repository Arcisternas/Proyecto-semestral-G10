package proyecto.codigoInterno.Habitats;

import java.util.*;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Animales.Bosque.*;

public class Bosque extends Habitat {
    public Bosque(){
        super();
    }
    public String getTipo(){
        return "Bosque";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Buho", "Lobo", "Ciervo", "Zorro");
        return permitidos;
    }
}
