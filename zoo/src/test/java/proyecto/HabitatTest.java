package proyecto;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import proyecto.codigoInterno.Zoologico;

public class HabitatTest {
    private static Zoologico zoo;
    @BeforeAll
    public static void setUp() {
        zoo = Zoologico.getInstance();
        zoo.addHabitat("HabitatArtico", "Ártico");
    }
    @Test
    @DisplayName("Test de añadir Animales")
    public void testAñadirAnimal(){
        zoo.getHabitatActual().addAnimal("Oso", "Oso Polar");
        assertEquals(1, zoo.getHabitatActual().getAnimales().size());
        assertEquals("Oso Polar", zoo.getHabitatActual().getAnimales().get(0).getEspecie());
        assertEquals("Oso", zoo.getHabitatActual().getAnimales().get(0).getNombre());
    }
    @Test
    @DisplayName("Test de eliminar Animales")
    public void testEliminarAnimal(){
        zoo.getHabitatActual().addAnimal("Oso", "Oso Polar");
        zoo.getHabitatActual().eliminarAnimal(zoo.getHabitatActual().getAnimales().get(0));
        assertEquals(0, zoo.getHabitatActual().getAnimales().size());
    }
}
