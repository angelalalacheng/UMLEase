package object;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class CompositionLine extends ConnectionComponent {
    private int xStart, yStart, xEnd, yEnd;

    public CompositionLine(int xStart, int yStart, int xEnd, int yEnd) {
        super(xStart, yStart, xEnd, yEnd);
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public void draw (Graphics2D g2d) {
        super.draw(g2d);

        double dx = xEnd - xStart;
        double dy = yEnd - yStart;

        // calculates the angle between the line and the x-axis
        double angle = Math.atan2(dy, dx);

        int diamondSize = 5;
        int[] xPoints = {0, diamondSize, 0, -diamondSize};
        int[] yPoints = {-diamondSize, 0, diamondSize, 0};

        // rotate and translate the diamond into position at the end of the line
        AffineTransform transform = new AffineTransform();
        transform.translate(xEnd, yEnd);
        transform.rotate(angle - Math.PI / 2);

        Shape diamond = transform.createTransformedShape(new Polygon(xPoints, yPoints, 4));

        g2d.draw(diamond);
    }

    public void move(int xS, int yS, int xE, int yE) {
        super.move(xS, yS, xE, yE);
        xStart += xS;
        yStart += yS;
        xEnd += xE;
        yEnd += yE;
    }

}
