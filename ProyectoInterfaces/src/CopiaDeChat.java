import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CopiaDeChat extends JFrame {
    static JTextArea areaArriba;
    static Icon iconoFlecha;
    static JButton bottonFlecha;

    public CopiaDeChat() {
        try {
            Image vacaBackground = ImageIO.read(new File("VacaBackground.jpg"));

            // Crea un background personalizado para poder meter la imagen
            JPanel backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(vacaBackground, 0, 0, getWidth(), getHeight(), this);
                }
            };

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(400, 400);
            this.setVisible(true);

            // Establece el diseño del JFrame como BorderLayout
            this.setLayout(new BorderLayout());

            // Añade el panel de fondo al centro del JFrame
            this.add(backgroundPanel, BorderLayout.CENTER);

            // Añade el texto en la parte superior
            this.add(panelArribaFun(), BorderLayout.NORTH);

            // Añade el botón en la parte izquierda
            this.add(giroALaDrecha(), BorderLayout.WEST);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JTextArea panelArribaFun() {
        areaArriba = new JTextArea("Bienvenidos a MilkShop");
        areaArriba.setOpaque(false);
        return areaArriba;
    }

    public static JButton giroALaDrecha() {
        iconoFlecha = new ImageIcon("./FechaDerecha.png");
        bottonFlecha = new JButton(iconoFlecha);
        return bottonFlecha;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PanelPrincipal();
        });
    }
}
