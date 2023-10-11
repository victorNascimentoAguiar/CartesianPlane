import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    //Image image;

    MyPanel() {

        //image = new ImageIcon("sky.png").getImage();
        this.setPreferredSize(new Dimension(640, 480));
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        int width = 640;
        int height = 480;
        int pointSize = 8;
        String coordinateX = "", coordinateY = "";

        int limite = (width / (width / 100));
        int space = width/30;
        int valueCoordinate = 0;

        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(0, (height / 2), width, (height / 2));
        g2D.drawLine((width / 2), 0, (width / 2), height);


        g2D.setPaint(Color.blue);
        g2D.fillOval(((width / 2) - (pointSize / 2)), ((height / 2) - (pointSize / 2)), pointSize, pointSize);

        // right side
        for (int i = 0; i < limite; i++) {
            g2D.fillOval((width / 2) - (pointSize / 2) + space, (height / 2) - (pointSize / 2), pointSize, pointSize);
            g2D.fillOval((width / 2) - (pointSize / 2), (height / 2) - (pointSize / 2) + space, pointSize, pointSize);
            coordinateX = coordinateY = String.valueOf(valueCoordinate + 1);
            // Letters
            g2D.drawString(coordinateX, (width / 2) - (pointSize / 2) + space, (height / 2) + (pointSize * 4));
            g2D.drawString("-" + coordinateY, (width / 2) - (pointSize * 4), (height / 2) + (pointSize + space));
            // Increment Variables
            valueCoordinate++;
            space += width / 30;
        }

        space = width / 30;
        valueCoordinate = 0;
        for (int i = limite; i > 0; i--) {
            // Ovals
            g2D.fillOval((width / 2) - (pointSize / 2) - space, (height / 2) - (pointSize / 2), pointSize, pointSize);
            g2D.fillOval((width / 2) - (pointSize / 2), (height / 2) - (pointSize / 2) - space, pointSize, pointSize);
            coordinateX = coordinateY = String.valueOf(valueCoordinate + 1);
            // Letters
            if (i != limite)
                g2D.drawString("-" + coordinateX, (width / 2) - (pointSize / 2) - space, (height / 2) + (pointSize * 4));
                g2D.drawString(coordinateY, (width / 2) - (pointSize * 4), (height / 2) + (pointSize - space));
            // Increment Variables
            valueCoordinate++;
            space += width / 30;
        }
    }
}