package proyecto.codigoInterno.Animales.Sabana;


import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Herbivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Jirafa extends Animal implements Herbivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;
  

    public Jirafa(String nombre, int id){
        super(nombre, id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Sabana/jirafa.png"));
        animo = -5;
    }
    public String getEspecie(){
        return "Jirafa";
    }
    public String getHabitat(){
        return "Sabana";
    }
    public void calcularAnimoSegunCompañeros(){
        animo = -5;
        for(Animal animal : this.getHabitatActualAnimal().getAnimales()){
            if (animal == this) {
                continue;
            }
            if(animal.getEspecie().equals("Cebra")){
                animo = animo + 1;
            }
            if (animal.getEspecie().equals("Elefante")) {
                animo = animo + 1;
            }
            if (animal.getEspecie().equals("Jirafa")) {
                animo = animo + 5;
            }
            if (animal.getEspecie().equals("León")) {
                animo = animo - 3;
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
