package proyecto.codigoInterno.Animales.Bosque;


import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Herbivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Ciervo extends Animal implements Herbivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;
   

    public Ciervo(String nombre, int id){
        super(nombre,id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Bosque/ciervo.png"));
        animo = -3;
    }
    public String getEspecie(){
        return "Ciervo";
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
                animo = animo + 1 ;
            }
            if (animal.getEspecie().equals("Ciervo")) {
                animo = animo + 5;
            }
            if (animal.getEspecie().equals("Lobo")) {
                animo = animo - 5;
            }
            if (animal.getEspecie().equals("Zorro")) {
                animo = animo - 1;
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
