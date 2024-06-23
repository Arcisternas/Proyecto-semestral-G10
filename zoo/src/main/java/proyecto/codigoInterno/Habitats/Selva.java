package proyecto.codigoInterno.Habitats;

import java.util.*;

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
