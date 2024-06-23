package proyecto.codigoInterno.Animales.Artico;


import java.util.concurrent.*;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;

public class Morsa extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
   

    public Morsa(String nombre){
        super(nombre);
        this.come = false;
    }
    public String getEspecie(){
        return "Morsa";
    }
    public String getHabitat(){
        return "Artico";
    }
    
    @Override
    public boolean comerCarne(boolean come) {
        this.come = come;
        return come;
    }
    @Override
    public String pedirCarne() {
        if(comerCarne(come)){
            futureTask.cancel(true);
        }
        futureTask = scheduler.schedule(() -> {
            // Aquí asumimos que la clase gestora tiene un método para manejar la desaparición
            desaparecer();
        }, 5, TimeUnit.MINUTES);
        return "Necesita carne...";
    }
    @Override
    public void desaparecer(){
        
        System.out.println("La foca ha desaparecido de la lista por no recibir carne en 5 minutos.");
    }
}