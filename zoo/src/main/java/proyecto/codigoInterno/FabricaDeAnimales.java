package proyecto.codigoInterno;

import proyecto.codigoInterno.Animales.Artico.*;
import proyecto.codigoInterno.Animales.Bosque.*;
import proyecto.codigoInterno.Animales.Desierto.*;
import proyecto.codigoInterno.Animales.Sabana.*;
import proyecto.codigoInterno.Animales.Selva.*;
import proyecto.codigoInterno.Animales.Animal;


public class FabricaDeAnimales {
    public static Animal crearAnimal(String nombre, int id, String tipoAnimal) {
        switch (tipoAnimal) {
            case "Foca":
                return new Foca(nombre,id);
            case "Morsa":
                return new Morsa(nombre,id);
            case "Oso Polar":
                return new OsoPolar(nombre,id);
            case "Pingüino":
                return new Pinguino(nombre,id);
            case "Buho":
                return new Buho(nombre,id);
            case "Ciervo":
                return new Ciervo(nombre,id);
            case "Lobo":
                return new Lobo(nombre,id);
            case "Zorro":
                return new Zorro(nombre,id);
            case "Camello":
                return new Camello(nombre,id);
            case "Escorpión":
                return new Escorpion(nombre,id);
            case "Cobra":
                return new Cobra(nombre,id);
            case "Zorro Fennec":
                return new ZorroFennec(nombre,id);
            case "Cebra":
                return new Cebra(nombre,id);
            case "Elefante":
                return new Elefante(nombre,id);
            case "Jirafa":
                return new Jirafa(nombre,id);
            case "León":
                return new Leon(nombre,id);
            case "Mono":
                return new Mono(nombre,id);
            case "Serpiente":
                return new Serpiente(nombre,id);
            case "Tigre":
                return new Tigre(nombre,id);
            case "Tucán":
                return new Tucan(nombre,id);
            default:
                return null;
        }
    }
}
