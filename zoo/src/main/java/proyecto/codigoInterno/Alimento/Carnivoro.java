package proyecto.codigoInterno.Alimento;

/**
 * Interface de animales carnivoros
 * @author Maria Jesus Olivares
 */

public interface Carnivoro {
    public boolean comerCarne(boolean come);  //metodo donde come carne el animal (depende de si hay carne o no)
    public String pedirCarne(); //metodo donde pedira carne el animal
   
}
