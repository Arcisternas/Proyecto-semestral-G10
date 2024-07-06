package proyecto.codigoInterno.Animales.Sabana;


import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class Leon extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;
    
    
    public Leon(String nombre, int id){
        super(nombre, id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Sabana/leon.png"));
        animo = 0;
    }
    public String getEspecie(){
        return "León";
    }
    public String getHabitat(){
        return "Sabana";
    }
    public void calcularAnimoSegunCompañeros(){
        animo = 0;
        for(Animal animal : this.getHabitatActualAnimal().getAnimales()){
            if (animal == this) {
                continue;
            }
            if(animal.getEspecie().equals("Cebra")){
                animo = animo - 1;
            }
            if (animal.getEspecie().equals("Elefante")) {
                animo = animo + 0;
            }
            if (animal.getEspecie().equals("Jirafa")) {
                animo = animo - 1;
            }
            if (animal.getEspecie().equals("León")) {
                animo = animo + 3;
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