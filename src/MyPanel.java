import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    MyPanel() {
        this.setPreferredSize(new Dimension(640, 480));
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        int width = 640;
        int height = 480;
        int pointSize = 8;
        String coordinateX = "", coordinateY = "";

        int limite = (width / (width / 100));
        int scale = 100;
        int valueCoordinate = 0;

        g2D.setPaint(Color.black);
        g2D.setStroke(new BasicStroke(3));
        g2D.drawLine(0, (height / 2), width, (height / 2));
        g2D.drawLine((width / 2), 0, (width / 2), height);

        g2D.setPaint(Color.black);
        g2D.fillOval(((width / 2) - (pointSize / 2)), ((height / 2) - (pointSize / 2)), pointSize, pointSize);

        // right side
        for (int i = 0; i < limite; i++) {
            g2D.setPaint(Color.black);
            g2D.fillOval((width / 2) - (pointSize / 2) + scale, (height / 2) - (pointSize / 2), pointSize, pointSize);
            g2D.fillOval((width / 2) - (pointSize / 2), (height / 2) - (pointSize / 2) + scale, pointSize, pointSize);
            coordinateX = coordinateY = String.valueOf(valueCoordinate + 1);
            // Letters
            g2D.setPaint(Color.blue);
            g2D.drawString(coordinateX, (width / 2) - (pointSize / 2) + scale, (height / 2) + (pointSize * 4));
            g2D.drawString("-" + coordinateY, (width / 2) - (pointSize * 4), (height / 2) + (pointSize + scale));
            // Increment Variables
            valueCoordinate++;
            scale += 100;
        }

        scale = 100;
        valueCoordinate = 0;
        for (int i = limite; i > 0; i--) {
            g2D.setPaint(Color.black);
            g2D.fillOval((width / 2) - (pointSize / 2) - scale, (height / 2) - (pointSize / 2), pointSize, pointSize);
            g2D.fillOval((width / 2) - (pointSize / 2), (height / 2) - (pointSize / 2) - scale, pointSize, pointSize);
            coordinateX = coordinateY = String.valueOf(valueCoordinate + 1);
            // Letters
            g2D.setPaint(Color.blue);
            g2D.drawString("-" + coordinateX, (width / 2) - (pointSize / 2) - scale, (height / 2) + (pointSize * 4));
            g2D.drawString(coordinateY, (width / 2) - (pointSize * 4), (height / 2) + (pointSize - scale));
            // Increment Variables
            valueCoordinate++;
            scale += 100;
        }
        scale = 100;
        g2D.setPaint(Color.red);
        g2D.drawLine((width / 2) + scale, (height / 2) - scale, (width / 2) + 2 * scale, (height / 2) - 2 * scale);
    }
}