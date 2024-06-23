package proyecto.codigoInterno.Habitats;

import java.util.*;

public class Sabana extends Habitat{
    public Sabana(String nombre){
        super(nombre);
    }
    public String getTipo(){
        return "Sabana";
    }
    public List<String> animalesPermitidos(){
        List<String> permitidos = Arrays.asList("Cebra", "Elefante", "Jirafa", "León");
        return permitidos;
    }
}
