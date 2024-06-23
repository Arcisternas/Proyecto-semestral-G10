package proyecto.codigoInterno.Animales.Sabana;

import java.util.concurrent.*;

import proyecto.codigoInterno.Alimento.Herbivoro;
import proyecto.codigoInterno.Animales.Animal;

public class Cebra extends Animal implements Herbivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    

    public Cebra(String nombre){
        super(nombre);
        this.come = false;
    }
    public String getEspecie(){
        return "Cebra";
    }
    public String getHabitat(){
        return "Sabana";
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
