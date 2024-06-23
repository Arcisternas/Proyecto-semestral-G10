package proyecto.codigoInterno.Animales.Artico;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;

public class Foca extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Foca(String nombre){
        super(nombre);
    }
    public String getEspecie(){
        return "Foca";
    }
    public String getHabitat(){
        return "Artico";
    }
    @Override
    public String comerCarne() {
        return "carne";
    }
    @Override
    public String pedirCarne() {
        return "Necesita carne...";
    }
    @Override
    public void contadorDesaparicion(List<Animal> animales) {
        scheduler.schedule(() -> {
            synchronized (animales) {
                if (animales.contains(this)) {
                    animales.remove(this);
                    System.out.println("La foca ha desaparecido de la lista por no recibir carne en 5 minutos.");
                }
            }
        }, 5, TimeUnit.MINUTES);
    }
}
