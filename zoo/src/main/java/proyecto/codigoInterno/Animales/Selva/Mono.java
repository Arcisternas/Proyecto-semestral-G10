package proyecto.codigoInterno.Animales.Selva;

import java.util.concurrent.*;

import proyecto.codigoInterno.Alimento.Herbivoro;
import proyecto.codigoInterno.Animales.Animal;

public class Mono extends Animal implements Herbivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
   

    public Mono(String nombre){
        super(nombre);
        this.come = false;
    }
    public String getEspecie(){
        return "Mono";
    }
    public String getHabitat(){
        return "Selva";
    }
   
    @Override
    public boolean comerPlanta(boolean come) {
        this.come = come;
        return come;
    }
    @Override
    public String pedirPlanta() {
        if(comerPlanta(come)){
            futureTask.cancel(true);
        }
        futureTask = scheduler.schedule(() -> {
            // Aquí asumimos que la clase gestora tiene un método para manejar la desaparición
            desaparecer();
        }, 5, TimeUnit.MINUTES);
        return "Necesita Plantas...";
    }
    @Override
    public void desaparecer(){
        
        System.out.println("La foca ha desaparecido de la lista por no recibir carne en 5 minutos.");
    }
}