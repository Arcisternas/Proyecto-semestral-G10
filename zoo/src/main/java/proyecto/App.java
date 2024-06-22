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
        
        Zoologico.getInstance().addHabitat("Habitat inicial de prueba", "Bosque");
        Ventana ventana = new Ventana();
    }
}
