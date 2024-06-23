package proyecto.codigoInterno.Animales;

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
}
