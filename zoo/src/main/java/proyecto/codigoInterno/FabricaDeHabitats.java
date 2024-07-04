package proyecto.codigoInterno;


import proyecto.codigoInterno.Habitats.*;
public class FabricaDeHabitats {
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
