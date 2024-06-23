package proyecto.codigoInterno.Animales.Artico;

import proyecto.codigoInterno.Animales.Animal;

public class OsoPolar extends Animal{
    public OsoPolar(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Oso Polar";
    }
    public String getHabitat(){
        return "Artico";
    }
}
