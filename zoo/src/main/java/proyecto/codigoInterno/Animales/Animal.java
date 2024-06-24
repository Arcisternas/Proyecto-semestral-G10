package proyecto.codigoInterno.Animales;

import proyecto.codigoInterno.Habitats.Habitat;

public abstract class Animal {
    private String nombre;
    public Animal(String nombre){
        this.nombre = nombre;
    }
    public abstract String getEspecie();
    public abstract String getHabitat();
    public String getNombre(){
        return nombre;
    }
    public abstract void pedirComida(Habitat habitat);
    public abstract void desaparecer(Habitat habitat);
    public abstract void comer();
}
