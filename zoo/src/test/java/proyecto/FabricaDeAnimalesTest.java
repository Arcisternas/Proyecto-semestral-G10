package proyecto;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.FabricaDeAnimales;
import proyecto.codigoInterno.Zoologico;

public class FabricaDeAnimalesTest {
    private static Zoologico zoo;
    @BeforeAll
    public static void setUp() {
        zoo = Zoologico.getInstance();
    }
    @Test
    @DisplayName("Test de creación de animales")
    public void testCrearAnimales() {
        String nombre = "nombre1";
        String tipo = "Foca";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre2";
        tipo = "Morsa";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre3";
        tipo = "Oso Polar";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre4";
        tipo = "Pingüino";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre5";
        tipo = "Buho";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre6";
        tipo = "Ciervo";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre7";
        tipo = "Lobo";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre8";
        tipo = "Zorro";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre9";
        tipo = "Camello";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre10";
        tipo = "Cobra";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre11";
        tipo = "Escorpión";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre12";
        tipo = "Zorro Fennec";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre13";
        tipo = "Cebra";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre14";
        tipo = "Elefante";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre15";
        tipo = "Jirafa";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre16";
        tipo = "León";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre17";
        tipo = "Mono";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre18";
        tipo = "Serpiente";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre19";
        tipo = "Tigre";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
        nombre = "nombre20";
        tipo = "Tucán";
        verificar(nombre, zoo.getAnimalId(), tipo);
        zoo.aumentarAnimalId();
    }
    public void verificar(String nombre, int id, String tipo){
        Animal animal = FabricaDeAnimales.crearAnimal(nombre, zoo.getAnimalId(), tipo);
        assertEquals(nombre, animal.getNombre());
        assertEquals(tipo, animal.getEspecie());
        assertEquals(zoo.getAnimalId(), animal.getId());
    }
}
