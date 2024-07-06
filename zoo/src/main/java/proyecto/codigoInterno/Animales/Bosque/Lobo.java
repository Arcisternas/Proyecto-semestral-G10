package proyecto.codigoInterno.Animales.Bosque;

import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Lobo extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;

    public Lobo(String nombre, int id){
        super(nombre, id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Bosque/lobo.png"));
        animo = -3;
    }
    public String getEspecie(){
        return "Lobo";
    }
    public String getHabitat(){
        return "Bosque";
    }
    public void calcularAnimoSegunCompañeros(){
        animo = -3;
        for(Animal animal : this.getHabitatActualAnimal().getAnimales()){
            if (animal == this) {
                continue;
            }
            if(animal.getEspecie().equals("Buho")){
                animo = animo - 2 ;
            }
            if (animal.getEspecie().equals("Ciervo")) {
                animo = animo - 3;
            }
            if (animal.getEspecie().equals("Lobo")) {
                animo = animo + 5;
            }
            if (animal.getEspecie().equals("Zorro")) {
                animo = animo + 0;
            }
        }
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