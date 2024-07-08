package proyecto.codigoInterno.Animales.Artico;

import java.util.concurrent.*;
import javax.swing.ImageIcon;

import proyecto.codigoInterno.Alimento.Carnivoro;
import proyecto.codigoInterno.Animales.Animal;
import proyecto.codigoInterno.Habitats.Habitat;

public class OsoPolar extends Animal implements Carnivoro{
    private static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> futureTask;
    private boolean come;
    private Habitat habitat;
    
    public OsoPolar(String nombre, int id){
        super(nombre, id);
        this.come = false;
        imagenIcon = new ImageIcon(getClass().getResource("/animales/Artico/polar.png"));
        animo = 5;
        dieta = "Carnivoro";
    }
    public String getEspecie(){
        return "Oso Polar";
    }
    public String getHabitat(){
        return "Artico";
    }
    public void calcularAnimoSegunCompañeros(){
        animo = 5;
        for(Animal animal : this.getHabitatActualAnimal().getAnimales()){
            if (animal == this) {
                continue;
            }
            if(animal.getEspecie().equals("Oso Polar")){
                animo = animo + 5;
            }
            if (animal.getEspecie().equals("Pingüino")) {
                animo = animo - 1;
            }
            if (animal.getEspecie().equals("Foca")) {
                animo = animo - 1;
            }
            if (animal.getEspecie().equals("Morsa")) {
                animo = animo - 2;
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
