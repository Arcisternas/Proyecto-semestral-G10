package proyecto.codigoInterno.Habitats;

import java.util.*;

public class Bosque extends Habitat {
    public Bosque(String nombre){
        super(nombre);
    }
    public String getTipo(){
        return "Bosque";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Buho", "Lobo", "Ciervo", "Zorro");
        return permitidos;
    }
}
