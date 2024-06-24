package proyecto.codigoInterno.Animales.Sabana;


import java.util.concurrent.*;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Leon extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;
    
    
    public Leon(String nombre){
        super(nombre);
        this.come = false;
    }
    public String getEspecie(){
        return "Leon";
    }
    public String getHabitat(){
        return "Sabana";
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
            desaparecer(habitat);
        }, 5, TimeUnit.MINUTES);
        return "Necesita carne...";
    }
    @Override
    public void desaparecer(Habitat habitat){
        habitat.eliminarAnimal(this);
    }
    @Override
    public void pedirComida(Habitat habitat) {
        this.habitat = habitat;
       pedirCarne();
    }
    public void comer() {
        comerCarne(come);
        pedirComida(habitat);
        come = false;
    }
}