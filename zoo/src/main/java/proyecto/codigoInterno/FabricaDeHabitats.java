package proyecto.codigoInterno;


import proyecto.codigoInterno.Habitats.*;

/**
 * Clase de Fabrica de Habitats
 * @author Ariel Cisternas
 */

public class FabricaDeHabitats {
    /**
     * Metodo estatico para la creacion de habitats
     * @param nombre nombre del habitat
     * @param tipoHabitat tipo de habitat (sabana, bosque, etc) 
     * @return objeto Habitat
     */
    public static Habitat crearHabitat(String nombre, String tipoHabitat) {
        switch (tipoHabitat) {
            case "Ártico":
                return new Artico(nombre);
            case "Bosque":
                return new Bosque(nombre);
            case "Desierto":
                return new Desierto(nombre);
            case "Sabana":
                return new Sabana(nombre);
            case "Selva":
                return new Selva(nombre);
            default:
                return null;
        }
    }
}
