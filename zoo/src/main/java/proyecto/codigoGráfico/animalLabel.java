package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

/**
 * Clase donde la imagen del animal se predetermina
 * @author Ariel Cisternas
 */
public class animalLabel extends JLabel {
    private int idAnimal; //id del animal al que le corresponde la imagen
    /**
     * Constructor donde se determina el tamaño de la imagen del animal
     * @param idAnimal id del animal al que le corresponde la imagen
     * @param imagen imagen del animal
     */
    public animalLabel(int idAnimal,ImageIcon imagen) {
        super();
        this.idAnimal = idAnimal;
        int imageWidth = imagen.getIconWidth()/15;
        int imageHeight = imagen.getIconHeight()/15;
        setIcon(new ImageIcon(imagen.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH)));
    }
    /**
     * metodo donde se recupera el id del animal
     * @return id
     */
    public int getIdAnimal(){
        return idAnimal;
    }
}
