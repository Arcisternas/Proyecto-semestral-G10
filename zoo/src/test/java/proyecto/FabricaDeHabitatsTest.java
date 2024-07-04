package proyecto;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import proyecto.codigoInterno.FabricaDeHabitats;
import proyecto.codigoInterno.Habitats.Habitat;


public class FabricaDeHabitatsTest {
    @DisplayName("Test de creación de habitats")
    @Test
    public void testCrearHabitats() {
        String nombre = "nombre1";
        String tipo = "Ártico";
        verificar(nombre, tipo);
        nombre = "nombre2";
        tipo = "Bosque";
        verificar(nombre, tipo);
        nombre = "nombre3";
        tipo = "Desierto";
        verificar(nombre, tipo);
        nombre = "nombre4";
        tipo = "Sabana";
        verificar(nombre, tipo);
        nombre = "nombre5";
        tipo = "Selva";
        verificar(nombre, tipo);
    }
    public void verificar(String nombre, String tipo) {
        Habitat habitat = FabricaDeHabitats.crearHabitat(nombre, tipo);
        assertEquals(nombre, habitat.getNombre());
        assertEquals(tipo, habitat.getTipo());
    }
}
