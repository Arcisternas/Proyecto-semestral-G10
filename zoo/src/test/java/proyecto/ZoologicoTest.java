package proyecto;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import proyecto.codigoInterno.Zoologico;

class ZoologicoTest {
    private static Zoologico zoo = Zoologico.getInstance();
    @Test
    @DisplayName("Test de instancia de Zoologico no nula")
    public void testInstanciaDeZoologico() {
        assertNotNull(zoo);
    }
    @Test
    @DisplayName("Test Zoologico es Singleton")
    public void testZoologicoEsSingleton() {
        Zoologico zoo2 = Zoologico.getInstance();
        assertEquals(zoo, zoo2);
    }
    @Test
    @DisplayName("Test Añadir hábitats")
    public void testAñadirHabitat() {
        String nombre;
        String tipo;
        nombre = "Habitat1";
        tipo = "Ártico";
        zoo.addHabitat(nombre, tipo);
        assertNotNull(zoo.getHabitats().get(0));
        assertEquals(1, zoo.getHabitats().size());
        assertTrue(zoo.getHabitats().get(0).getNombre().equals(nombre));
        assertTrue(zoo.getHabitats().get(0).getTipo().equals(tipo));
        nombre = "Habitat2";
        tipo = "Bosque";
        zoo.addHabitat(nombre, tipo);
        assertNotNull(zoo.getHabitats().get(1));
        assertEquals(2, zoo.getHabitats().size());
        assertTrue(zoo.getHabitats().get(1).getNombre().equals(nombre));
        assertTrue(zoo.getHabitats().get(1).getTipo().equals(tipo));
        nombre = "Habitat3";
        tipo = "Desierto";
        zoo.addHabitat(nombre, tipo);
        assertNotNull(zoo.getHabitats().get(2));
        assertEquals(3, zoo.getHabitats().size());
        assertTrue(zoo.getHabitats().get(2).getNombre().equals(nombre));
        assertTrue(zoo.getHabitats().get(2).getTipo().equals(tipo));
        nombre = "Habitat4";
        tipo = "Sabana";
        zoo.addHabitat(nombre, tipo);
        assertNotNull(zoo.getHabitats().get(3));
        assertEquals(4, zoo.getHabitats().size());
        assertTrue(zoo.getHabitats().get(3).getNombre().equals(nombre));
        assertTrue(zoo.getHabitats().get(3).getTipo().equals(tipo));
        nombre = "Habitat5";
        tipo = "Selva";
        zoo.addHabitat(nombre, tipo);
        assertNotNull(zoo.getHabitats().get(4));
        assertEquals(5, zoo.getHabitats().size());
        assertTrue(zoo.getHabitats().get(4).getNombre().equals(nombre));
        assertTrue(zoo.getHabitats().get(4).getTipo().equals(tipo));

    }
    @Test
    @DisplayName("Test Cambiar hábitat actual")
    public void testCambiarHabitatActual() {
        zoo.addHabitat("Habitat1", "Ártico");
        zoo.addHabitat("Habitat2", "Bosque");
        zoo.setHabitatActual(zoo.getHabitats().get(1));
        assertEquals(zoo.getHabitats().get(1), zoo.getHabitatActual());
    }
}
