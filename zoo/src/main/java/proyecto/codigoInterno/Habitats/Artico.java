package proyecto.codigoInterno.Habitats;

import java.util.*;
public class Artico extends Habitat{
    public Artico(String nombre){
        super(nombre);
    }
    public String getTipo(){
        return "Ártico";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Oso Polar", "Pingüino", "Foca", "Morsa");
        return permitidos;
    }
}
