package proyecto.codigoInterno.Alimento;

import java.util.List;

import proyecto.codigoInterno.Animales.Animal;

public interface Herbivoro {
    public String comerPlanta();
    public String pedirPlanta();
    public void contadorDesaparicion(List<Animal> Animales);
}
