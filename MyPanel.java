import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class MyPanel extends JPanel {

    MyPanel() {
        this.setPreferredSize(new Dimension(800, 600));
    }

    public void paint(Graphics g) {

        Graphics2D g2D = (Graphics2D) g;

        int width = 800;
        int height = 600;
        int pointSize = 8;
        String coordinateX = "", coordinateY = "";

        int limite = (width / (width / 100));
        int scale = 50;
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
            scale += 50;
        }

        scale = 50;
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
            scale += 50;
        }

        // points to draw a polygon
        int[] xPoints = {141, 150, 166, 175, 175, 166, 150, 141};
        int[] yPoints = {75, 79, 79, 75, 62, 50, 50, 62};

        AffineTransform transform = new AffineTransform();

        Shape scaledPolygon = transform.createTransformedShape(new Polygon(xPoints, yPoints, 8));

        // draw a green octagon
        g2D.setPaint(Color.yellow);
        g2D.fill(scaledPolygon);

        AffineTransform transform1 = new AffineTransform();
        transform1.rotate(Math.toRadians(60));
        transform1.translate(1, 2);
        transform1.scale(2.0, 2.0);

        Shape scaledPolygonRed = transform1.createTransformedShape(new Polygon(xPoints, yPoints, 8));

        // draw a red octagon
        g2D.setPaint(Color.blue);
        g2D.fill(scaledPolygonRed);

        AffineTransform transform2 = new AffineTransform();
        transform2.scale(2.0, 2.0);
        transform2.rotate(Math.toRadians(60));
        transform2.translate(1, 2);


        Shape scaledPolygonBlue = transform2.createTransformedShape(new Polygon(xPoints, yPoints, 8));

        // draw a red octagon
        g2D.setPaint(Color.black);
        g2D.fill(scaledPolygonBlue);
    }
}