package proyecto.codigoGráfico;

import javax.swing.*;

import proyecto.codigoInterno.Zoologico;

import java.awt.*;

public class PanelHabitat extends JPanel { //Utilize patron singleton, ya que solo habra uno incializado y necesito acceder a el desde otras clases
    private static PanelHabitat instance = new PanelHabitat();
    private ImageIcon habitatImg;
    private JLabel habitat;
    private PanelHabitat() {
        super();
        setLayout(new BorderLayout());
        habitat = new JLabel();
        habitat.setHorizontalAlignment(JLabel.CENTER);
        habitat.setVerticalAlignment(JLabel.CENTER);
        add(habitat, BorderLayout.CENTER);
    }
    public static PanelHabitat getInstance() {
        return instance;
    }
    public void actualizarimagen(){
        switch (Zoologico.getInstance().getHabitatActual().getTipo()) {
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
            default:
                
                break;
        }
        if (habitatImg == null || habitatImg.getImage() == null) {System.out.println("Error cargando imagen");} //Probando si carga la imagen
        habitat.setIcon(new ImageIcon(habitatImg.getImage().getScaledInstance(1000, 900, Image.SCALE_SMOOTH)));
    }
}
