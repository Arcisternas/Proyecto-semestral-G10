package proyecto.codigoInterno.Animales.Bosque;

import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Buho extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;

    public Buho(String nombre, int id){
        super(nombre, id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Bosque/buho.png"));
        animo = 5;
    }
    public String getEspecie(){
        return "Buho";
    }
    public String getHabitat(){
        return "Bosque";
    }
    public void calcularAnimoSegunCompañeros(){
        animo = 5;
        for(Animal animal : this.getHabitatActualAnimal().getAnimales()){
            if (animal == this) {
                continue;
            }
            if(animal.getEspecie().equals("Buho")){
                animo = animo - 3 ;
            }
            if (animal.getEspecie().equals("Ciervo")) {
                animo = animo + 1;
            }
            if (animal.getEspecie().equals("Lobo")) {
                animo = animo - 3;
            }
            if (animal.getEspecie().equals("Zorro")) {
                animo = animo + 1;
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
