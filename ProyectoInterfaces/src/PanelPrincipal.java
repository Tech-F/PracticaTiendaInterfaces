import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanelPrincipal extends JFrame {
    static JTextArea areaArriba;
    static Icon iconoFlecha;
    static JButton bottonFlecha;

    static JPanel backgroundPanel;

    static JFrame framePrincipal;

    public static void todoCreado(){

        try {
            framePrincipal=new PanelPrincipal();
            Image vacaBackground = ImageIO.read(new File("VacaBackground.jpg"));

            // Crea un background personalizado para poder meter la imagen
            backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(vacaBackground, 0, 0, getWidth(), getHeight(), this);
                }
            };

            framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            framePrincipal.setSize(400, 400);
            framePrincipal.setVisible(true);

            // Establece el diseño del JFrame como BorderLayout
            framePrincipal.setLayout(new BorderLayout());

            // Añade el panel de fondo al centro del JFrame
            framePrincipal.add(backgroundPanel, BorderLayout.CENTER);

            // Añade el texto en la parte superior
            framePrincipal.add(panelArribaFun(), BorderLayout.NORTH);

            // Añade el botón en la parte izquierda
            framePrincipal.add(giroALaDrecha(), BorderLayout.WEST);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public PanelPrincipal() {
    }

    public static JTextArea panelArribaFun() {

        areaArriba = new JTextArea("Benvidos a MilkShop");
        areaArriba.setOpaque(false);
        return areaArriba;

    }

    public static JButton giroALaDrecha() {
        iconoFlecha = new ImageIcon("./FechaDerecha.png");
        bottonFlecha = new JButton(iconoFlecha);
        return bottonFlecha;


    }

    public static void main(String[] args) {

    }


}
