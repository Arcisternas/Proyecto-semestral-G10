package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

public class PanelHabitat extends JPanel {
    public PanelHabitat() {
        super();
        setLayout(new BorderLayout());
        JLabel habitat = new JLabel();
        habitat.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon habitatImg = new ImageIcon(getClass().getResource("/habitats/desierto.png"));
        if (habitatImg == null || habitatImg.getImage() == null) {System.out.println("Error cargando imagen");} //Probando si carga la imagen
        habitat.setIcon(new ImageIcon(habitatImg.getImage().getScaledInstance(1000, 900, Image.SCALE_SMOOTH)));
        add(habitat, BorderLayout.CENTER);
        setOpaque(false);
    }
}
