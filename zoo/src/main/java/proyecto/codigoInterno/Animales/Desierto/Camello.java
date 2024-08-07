package proyecto.codigoInterno.Animales.Desierto;


import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Herbivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Camello extends Animal implements Herbivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;

    public Camello(String nombre, int id){
        super(nombre, id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Desierto/camello.png"));
        animo = -3;
        dieta = "Herbivoro";
    }
    public String getEspecie(){
        return "Camello";
    }
    public String getHabitat(){
        return "Desierto";
    }
    public void calcularAnimoSegunCompañeros(){
        animo = -3;
        for(Animal animal : this.getHabitatActualAnimal().getAnimales()){
            if (animal == this) {
                continue;
            }
            if(animal.getEspecie().equals("Camello")){
                animo = animo + 3;
            }
            if (animal.getEspecie().equals("Cobra")) {
                animo = animo - 1;
            }
            if (animal.getEspecie().equals("Escorpión")) {
                animo = animo - 1;
            }
            if (animal.getEspecie().equals("Zorro Fennec")) {
                animo = animo + 1;
            }
        }
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
