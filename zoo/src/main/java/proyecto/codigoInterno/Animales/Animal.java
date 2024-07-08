package proyecto.codigoInterno.Animales;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.Habitats.Habitat;
import javax.swing.ImageIcon;

public abstract class Animal {
    private String nombre;
    private int id;
    private Habitat habitatActualAnimal;
    protected ImageIcon imagenIcon;
    protected int animo; 
    protected String dieta;
    public Animal(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public int getId(){
        return id;
    }
    public ImageIcon getImagenIcon(){
        return imagenIcon;
    }
    public int getAnimo(){
        return animo;
    }
    public Habitat getHabitatActualAnimal(){
        return habitatActualAnimal;
    }
    public void setHabitatActualAnimal(Habitat habitat){
        this.habitatActualAnimal = habitat;
    }
    public void desaparecer(Habitat habitat){
        habitat.eliminarAnimal(this);
        PanelHabitat.getInstance().eliminarAnimalLabelPanel(this);
        habitat.actualizarAnimoAnimales();
    }
    public String getDieta(){
        return dieta;
    }
    public abstract String getEspecie();
    public abstract String getHabitat();
    public abstract void calcularAnimoSegunCompañeros();
    public abstract void pedirComida(Habitat habitat);
    public abstract void comer();
}
