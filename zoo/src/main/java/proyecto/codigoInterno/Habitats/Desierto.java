package proyecto.codigoInterno.Habitats;

import java.util.*;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Animales.Desierto.*;

public class Desierto extends Habitat{
    public Desierto(){
        super();
    }
    public String getTipo(){
        return "Desierto";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Camello", "Cobra", "Escorpión", "Zorro Fennec");
        return permitidos;
    }

}
