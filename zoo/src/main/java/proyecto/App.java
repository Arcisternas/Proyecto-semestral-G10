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
        //(Pruebas de lógica interna, ignorar)
        Habitat bosque = new Bosque();
        Habitat artico = new Artico();
        Habitat sabana = new Sabana();
        Habitat selva = new Selva();
        Habitat desierto = new Desierto();
        for(int i=0;i<5;i++){
            Zoologico.getInstance().addHabitat(bosque);
            Zoologico.getInstance().addHabitat(artico);
            Zoologico.getInstance().addHabitat(sabana);
            Zoologico.getInstance().addHabitat(selva);
    
        }
        Ventana ventana = new Ventana();
    }
}
