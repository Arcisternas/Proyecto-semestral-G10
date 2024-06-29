package proyecto.codigoGráfico;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;

import java.awt.*;
import java.util.Random;

public class PanelHabitat extends JPanel { //Utilice patron singleton, ya que solo habra uno incializado y necesito acceder a el desde otras clases
    private static PanelHabitat instance = new PanelHabitat();
    private ImageIcon habitatImg;
    private Zoologico zoo = Zoologico.getInstance();
    private PanelHabitat() {
        super();
        setLayout(null);
        setPreferredSize(new Dimension(1000,900));
        setBounds(0, 0, 1000, 900);
    }
    public static PanelHabitat getInstance() {
        return instance;
    }
    public void actualizarimagen(){ //pendiente: Actualizar imagen fondo e imagen animal por separado
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
        actualizarAnimalesPanel();   
    }
    public void actualizarAnimalesPanel(){
        removeAll();
        if (zoo.getHabitatActual() != null) {
            for (ImageIcon imagen : zoo.getHabitatActual().getImagenesAnimales()) {
                int imageWidth = imagen.getIconWidth()/15;
                int imageHeight = imagen.getIconHeight()/15;
                Random rand = new Random();
                int x = rand.nextInt(PanelHabitat.getInstance().getWidth()-imageWidth);
                int y = rand.nextInt(PanelHabitat.getInstance().getHeight()-imageHeight);
                JLabel animal = new JLabel();
                animal.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
                animal.setBounds(x, y, imageWidth, imageHeight);
                add(animal);
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (habitatImg != null && habitatImg.getImage() != null) {
            Image imagen = new ImageIcon(habitatImg.getImage().getScaledInstance(1000, 900, Image.SCALE_SMOOTH)).getImage();
            g.drawImage(imagen, 0, 0, 1000, 900, this);
    }
}
}