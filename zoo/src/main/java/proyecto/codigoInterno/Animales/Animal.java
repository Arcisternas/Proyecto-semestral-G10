package proyecto.codigoInterno.Animales;

import proyecto.codigoInterno.Habitats.Habitat;
import javax.swing.ImageIcon;

public abstract class Animal {
    private String nombre;
    protected ImageIcon imagenIcon;
    public Animal(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public ImageIcon getImagenIcon(){
        return imagenIcon;
    }
    public abstract String getEspecie();
    public abstract String getHabitat();
    public abstract void pedirComida(Habitat habitat);
    public void desaparecer(Habitat habitat){
        habitat.eliminarAnimal(this);
        habitat.eliminarImagenAnimal(this.getImagenIcon());
    }
    public abstract void comer();
}
