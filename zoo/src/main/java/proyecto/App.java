package proyecto;
import proyecto.codigoGráfico.*;
import proyecto.codigoInterno.*;

//(Para pruebas de lógica interna)
import proyecto.codigoInterno.Habitats.*;
import proyecto.codigoInterno.Animales.*;
import proyecto.codigoInterno.Animales.Bosque.*;
import proyecto.codigoInterno.Animales.Artico.*;


public final class App {
    private App() {
    }
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        
        //(Pruebas de lógica interna)
        Habitat bosque = new Bosque();
        Habitat artico = new Artico();
        Animal Lobo = new Lobo();
        Zoologico.getInstance().addHabitat(bosque);
        Zoologico.getInstance().addHabitat(artico);
        bosque.addAnimal(Lobo);
        artico.addAnimal(Lobo);
        System.out.println(Zoologico.getInstance().getTipoHabitats());
        System.out.println(bosque.getTipoAnimales());
        System.out.println(artico.getTipoAnimales());
        
    }
}
