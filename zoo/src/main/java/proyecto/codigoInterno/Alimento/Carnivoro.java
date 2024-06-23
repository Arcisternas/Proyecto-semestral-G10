package proyecto.codigoInterno.Alimento;

import java.util.List;

import proyecto.codigoInterno.Animales.Animal;

public interface Carnivoro {
    public String comerCarne();
    public String pedirCarne();
    public void contadorDesaparicion(List<Animal> Animales);
}
