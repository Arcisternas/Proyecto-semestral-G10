package proyecto.codigoInterno;

import proyecto.codigoInterno.Animales.Artico.*;
import proyecto.codigoInterno.Animales.Bosque.*;
import proyecto.codigoInterno.Animales.Desierto.*;
import proyecto.codigoInterno.Animales.Sabana.*;
import proyecto.codigoInterno.Animales.Selva.*;
import proyecto.codigoInterno.Animales.Animal;


public class FabricaDeAnimales {
    public static Animal crearAnimal(String nombre, String tipoAnimal) {
        switch (tipoAnimal) {
            case "Foca":
                return new Foca(nombre);
            case "Morsa":
                return new Morsa(nombre);
            case "Oso Polar":
                return new OsoPolar(nombre);
            case "Pingüino":
                return new Pinguino(nombre);
            case "Buho":
                return new Buho(nombre);
            case "Ciervo":
                return new Ciervo(nombre);
            case "Lobo":
                return new Lobo(nombre);
            case "Zorro":
                return new Zorro(nombre);
            case "Camello":
                return new Camello(nombre);
            case "Escorpion":
                return new Escorpion(nombre);
            case "Cobra":
                return new Cobra(nombre);
            case "Zorro Fennec":
                return new ZorroFennec(nombre);
            case "Cebra":
                return new Cebra(nombre);
            case "Elefante":
                return new Elefante(nombre);
            case "Jirafa":
                return new Jirafa(nombre);
            case "Leon":
                return new Leon(nombre);
            case "Mono":
                return new Mono(nombre);
            case "Serpiente":
                return new Serpiente(nombre);
            case "Tigre":
                return new Tigre(nombre);
            case "Tucan":
                return new Tucan(nombre);
            default:
                return null;
        }
    }
}
