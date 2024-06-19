package proyecto.codigoGráfico;

import javax.swing.*;
import java.awt.*;

public class PanelIntro extends JPanel{
    public PanelIntro(){
        super();
        setLayout(new BorderLayout());
        JLabel label = new JLabel("¡Bienvenido al zoológico!");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);
    }
}
