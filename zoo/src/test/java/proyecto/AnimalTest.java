package proyecto;

import org.junit.jupiter.api.*;

import proyecto.codigoInterno.Zoologico;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
     private static Zoologico zoo;
    @BeforeAll
    public static void setUp() {
        zoo = Zoologico.getInstance();
        zoo.addHabitat("HabitatArtico", "Ártico");
        zoo.getHabitatActual().addAnimal("Oso", "Oso Polar");
    }
    @Test
    @DisplayName("Test de Animo de Animales")
    public void testAnimoAnimal(){
        zoo.getHabitatActual().getAnimales().get(0).calcularAnimoSegunCompañeros();
        assertEquals(5, zoo.getHabitatActual().getAnimales().get(0).getAnimo());
        zoo.getHabitatActual().addAnimal("Pingüino", "Pingüino");
        zoo.getHabitatActual().getAnimales().get(0).calcularAnimoSegunCompañeros();
        zoo.getHabitatActual().getAnimales().get(1).calcularAnimoSegunCompañeros();
        assertEquals(4, zoo.getHabitatActual().getAnimales().get(0).getAnimo());
        assertEquals(-7, zoo.getHabitatActual().getAnimales().get(1).getAnimo());
    }
}
