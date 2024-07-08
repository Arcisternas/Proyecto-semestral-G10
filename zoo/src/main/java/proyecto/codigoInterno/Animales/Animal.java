package proyecto.codigoInterno.Animales;

import proyecto.codigoGráfico.PanelHabitat;
import proyecto.codigoInterno.Habitats.Habitat;
import javax.swing.ImageIcon;

/**
 * Clase abtracta de los animales (Se especificara solo este ya que el resto cambia en nombres o pocas cosas segun el animal)
 * @author Ariel Cisternas
 * @author Maria Jesus Olivares
 */

public abstract class Animal {
    private String nombre;  //nombre  del animal
    private int id; //id del animal 
    private Habitat habitatActualAnimal; //habitat actual del animal
    protected ImageIcon imagenIcon; //imagen del animal
    protected int animo; //animo del animal (segun compañeros)
    protected String dieta; //dieta del animal (herbivoro o carnivoro)
    /**
     * Constructor del animal donde se determina el id y el nombre
     * @param nombre del animal
     * @param id del animal
     */
    public Animal(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    }
    /**
     * Metodo para recuperar el nombre del animal
     * @return String nombre
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * metodo para recuperar el id del animal
     * @return int id
     */
    public int getId(){
        return id;
    }
    /**
     * Metodo que retorna la imagen del animal
     * @return imagen del animal
     */
    public ImageIcon getImagenIcon(){
        return imagenIcon;
    }
    /**
     * Metodo que retorna el animo del animal
     * @return int animo
     */
    public int getAnimo(){
        return animo;
    }
    /**
     * Metodo que retorna el habitat actual
     * @return Habitat habitat actual
     */
    public Habitat getHabitatActualAnimal(){
        return habitatActualAnimal;
    }
    /**
     * Metodo que determina el habitat en el que se encuentra el animal
     * @param habitat habitat actual
     */
    public void setHabitatActualAnimal(Habitat habitat){
        this.habitatActualAnimal = habitat;
    }
    /**
     * Metodo que desaparece al animal del habitat
     * @param habitat
     */
    public void desaparecer(Habitat habitat){
        habitat.eliminarAnimal(this);
        PanelHabitat.getInstance().eliminarAnimalLabelPanel(this);
        habitat.actualizarAnimoAnimales();
    }
    /**
     * metodo que recupera el tipo de dieta del animal
     * @return String dieta
     */
    public String getDieta(){
        return dieta;
    }
    public abstract String getEspecie(); //Metodo que retorna la especie del animal
    public abstract String getHabitat(); //metodo que retorna el habitat del animal
    public abstract void calcularAnimoSegunCompañeros(); //Metoddo que calcula el animal segun los compañeros existentes en el habitat
    public abstract void pedirComida(Habitat habitat); //metodo donde el animal pide comida cada 5 min
    public abstract void comer(); //metodo con el cual come el animal y se cancela su desaparicion
}
