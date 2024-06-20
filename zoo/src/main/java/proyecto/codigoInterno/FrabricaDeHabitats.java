package proyecto.codigoInterno;


import proyecto.codigoInterno.Habitats.*;
public class FrabricaDeHabitats {
    public static Habitat crearHabitat(String tipoHabitat) {
        switch (tipoHabitat) {
            case "Ártico":
                return new Artico();
            case "Bosque":
                return new Bosque();
            case "Desierto":
                return new Desierto();
            case "Sabana":
                return new Sabana();
            case "Selva":
                return new Selva();
            default:
                return null;
        }
    }
}
