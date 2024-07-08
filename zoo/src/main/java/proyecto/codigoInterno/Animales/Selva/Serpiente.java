package proyecto.codigoInterno.Animales.Selva;


import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Serpiente extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;
    
    
    public Serpiente(String nombre, int id){
        super(nombre, id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Selva/serpiente.png"));
        animo = 5;
        dieta = "Carnivoro";
    }
    public String getEspecie(){
        return "Serpiente";
    }
    public String getHabitat(){
        return "Selva";
    }
    public void calcularAnimoSegunCompañeros(){
        animo = 5;
        for(Animal animal : this.getHabitatActualAnimal().getAnimales()){
            if (animal == this) {
                continue;
            }
            if(animal.getEspecie().equals("Mono")){
                animo = animo + 0;
            }
            if (animal.getEspecie().equals("Serpiente")) {
                animo = animo - 3;
            }
            if (animal.getEspecie().equals("Tigre")) {
                animo = animo + 1;
            }
            if (animal.getEspecie().equals("Tucán")) {
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
