package proyecto.codigoInterno.Animales.Selva;

import java.util.concurrent.*;

import proyecto.codigoInterno.Alimento.Herbivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Tucan extends Animal  implements Herbivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;
  

    public Tucan(String nombre){
        super(nombre);
        this.come = false;
    }
    public String getEspecie(){
        return "Tucan";
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
            
        desaparecer(habitat);
        }, 5, TimeUnit.MINUTES);
        return "Necesita Plantas...";
    }
    @Override
    public void desaparecer(Habitat habitat){
        habitat.eliminarAnimal(this);
    }
    @Override
    public void pedirComida(Habitat habitat) {
    this.habitat = habitat;
       pedirPlanta();
    }
    
    @Override
    public void comer() {
        comerPlanta(come);
        pedirComida(habitat);
        come = false;
    }
}
