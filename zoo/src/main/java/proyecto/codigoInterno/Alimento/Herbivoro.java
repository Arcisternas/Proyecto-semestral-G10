package proyecto.codigoInterno.Alimento;


/**
 * Interface de animales herbivoros
 * @author Maria Jesus Olivares
 */
public interface Herbivoro {
    public boolean comerPlanta(boolean come); //metodo con el cual come plantas el animal (si hay)
    public String pedirPlanta();    //metodo con el cual pide comida el animal
    
}
