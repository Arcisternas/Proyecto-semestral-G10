package proyecto.codigoInterno.Animales.Bosque;

import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Zorro extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
   private Habitat habitat;

    public Zorro(String nombre){
        super(nombre);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Bosque/zorro.png"));
    }
    public String getEspecie(){
        return "Zorro";
    }
    public String getHabitat(){
        return "Bosque";
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