package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;


public class animalLabel extends JLabel {
    private int idAnimal;
    public animalLabel(int idAnimal,ImageIcon imagen) {
        super();
        this.idAnimal = idAnimal;
        int imageWidth = imagen.getIconWidth()/15;
        int imageHeight = imagen.getIconHeight()/15;
        setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
    }
    public int getIdAnimal(){
        return idAnimal;
    }
}
