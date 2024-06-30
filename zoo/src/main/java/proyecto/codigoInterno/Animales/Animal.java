package proyecto.codigoInterno.Animales;

import proyecto.codigoInterno.Habitats.Habitat;
import javax.swing.ImageIcon;

public abstract class Animal {
    private String nombre;
    protected ImageIcon imagenIcon;
    private Habitat habitatActualAnimal;
    public Animal(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public ImageIcon getImagenIcon(){
        return imagenIcon;
    }
    public Habitat getHabitatActualAnimal(){
        return habitatActualAnimal;
    }
    public void setHabitatActualAnimal(Habitat habitat){
        this.habitatActualAnimal = habitat;
    }
    public void desaparecer(Habitat habitat){
        habitat.eliminarAnimal(this);
        habitat.eliminarImagenAnimal(this.getImagenIcon());
    }
    public abstract String getEspecie();
    public abstract String getHabitat();
    public abstract void pedirComida(Habitat habitat);
    public abstract void comer();
}
