package object;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class GeneralizationLine extends ConnectionComponent {
    private int xStart, yStart, xEnd, yEnd;

    public GeneralizationLine(int xStart, int yStart, int xEnd, int yEnd) {
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

        double angle = Math.atan2(dy, dx);

        Polygon trianglePoints = new Polygon();
        trianglePoints.addPoint(0,5);
        trianglePoints.addPoint(-5, -5);
        trianglePoints.addPoint(5,-5);

        AffineTransform transform = new AffineTransform();
        transform.translate(xEnd, yEnd);
        transform.rotate(angle - Math.PI / 2);

        Shape triangle = transform.createTransformedShape(trianglePoints);

        g2d.draw(triangle);
    }

    public void move(int xS, int yS, int xE, int yE) {
        super.move(xS, yS, xE, yE);
        xStart += xS;
        yStart += yS;
        xEnd += xE;
        yEnd += yE;
    }
}
