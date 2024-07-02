package proyecto.codigoGráfico;

import proyecto.codigoInterno.Zoologico;
import proyecto.codigoInterno.Animales.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;
import javax.swing.Timer;

public class PanelHabitat extends JPanel { //Utilice patron singleton, ya que solo habra uno incializado y necesito acceder a el desde otras clases
    private static PanelHabitat instance = new PanelHabitat();
    private ImageIcon habitatImg;
    private Zoologico zoo = Zoologico.getInstance();
    private List<animalLabel> animalesLabels = new ArrayList<>();
    private Timer timer;
    private PanelHabitat() {
        super();
        setLayout(null);
        setPreferredSize(new Dimension(1000,900));
        setBounds(0, 0, 1000, 900);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movimientoAnimales();
                repaint();
            }
        });
        timer.start();
    }
    public static PanelHabitat getInstance() {
        return instance;
    }
    public void actualizarImagenesPanel(){
        actualizarFondoPanel();
        actualizarAnimalesPanel();
    }
    public void actualizarFondoPanel(){
        String tipo;
        if (zoo.getHabitatActual() == null) {
            tipo =  "intro";
        }
        else {
            tipo = zoo.getHabitatActual().getTipo();
        }
        switch (tipo) {
            case "Ártico":
                habitatImg = new ImageIcon(getClass().getResource("/habitats/artico.png"));
                repaint();
                break;
            case "Bosque": 
                habitatImg = new ImageIcon(getClass().getResource("/habitats/bosque.png"));
                repaint();
                break;
            case "Desierto":
                habitatImg = new ImageIcon(getClass().getResource("/habitats/desierto.png"));
                repaint();
                break;
            case "Sabana": 
                habitatImg = new ImageIcon(getClass().getResource("/habitats/sabana.png"));
                repaint();
                break;
            case "Selva":
                habitatImg = new ImageIcon(getClass().getResource("/habitats/selva.png"));
                repaint();
                break;
            case "intro":
                habitatImg = new ImageIcon(getClass().getResource("/bienvenida_zoo.png"));
                repaint();
                break;
            default:
                habitatImg = new ImageIcon(getClass().getResource("/bienvenida_zoo.png"));
                repaint();
                break;
        }
        if (habitatImg == null || habitatImg.getImage() == null) {System.out.println("Error cargando imagen");} //Probando si carga la imagen
    }
    public void actualizarAnimalesPanel(){
        removeAll();
        if (zoo.getHabitatActual() != null) {
            for (Animal animal : zoo.getHabitatActual().getAnimales()) {
                añadirImagenAnimalPanel(animal);
            }
        }
    }
    public void añadirImagenAnimalPanel(Animal animal){
        ImageIcon imagen = animal.getImagenIcon();
        int imageWidth = imagen.getIconWidth()/15;
        int imageHeight = imagen.getIconHeight()/15;
        Random rand = new Random();
        int x = rand.nextInt(PanelHabitat.getInstance().getWidth()-imageWidth);
        int y = rand.nextInt(PanelHabitat.getInstance().getHeight()-imageHeight);
        animalLabel animalLabel = new animalLabel(animal.getId(),imagen);
        animalLabel.setBounds(x, y, imageWidth, imageHeight);
        add(animalLabel);
        animalesLabels.add(animalLabel);
        repaint();
    }
    public void movimientoAnimales(){
        for (animalLabel animal : animalesLabels) {
            Random rand = new Random();
            int x = animal.getX() + rand.nextInt(50) -25;
            int y = animal.getY() + rand.nextInt(50) -25;
            x = Math.max(0, Math.min(x, getWidth() - animal.getWidth()));
            y = Math.max(0, Math.min(y, getHeight() - animal.getHeight()));
            animal.setLocation(x, y);
        }
    }
    public void eliminarAnimalLabelPanel(Animal animal){
        for (animalLabel animalLabel : animalesLabels) {
            if (animalLabel.getIdAnimal() == animal.getId()) {
                animalesLabels.remove(animalLabel);
                remove(animalLabel);
                revalidate();
                break;
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (habitatImg != null && habitatImg.getImage() != null) {
            g.drawImage(habitatImg.getImage(), 0, 0, 1000, 900, this);
    }
}
}