import java.awt.*;

public class AssociationLine extends ConnectionComponent {
    private int xStart, yStart, xEnd, yEnd;
    public AssociationLine(int xStart, int yStart, int xEnd, int yEnd) {
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

        int[] xPoints = {xEnd, (int) (xEnd - 10 * Math.cos(angle - Math.PI / 6)), (int) (xEnd - 10 * Math.cos(angle + Math.PI / 6))};
        int[] yPoints = {yEnd, (int) (yEnd - 10 * Math.sin(angle - Math.PI / 6)), (int) (yEnd - 10 * Math.sin(angle + Math.PI / 6))};

        g2d.drawLine(xPoints[0], yPoints[0], xPoints[1], yPoints[1]);
        g2d.drawLine(xPoints[0], yPoints[0], xPoints[2], yPoints[2]);
    }

    public void move(int x, int y) {
        super.move(x, y);
        xStart += x;
        yStart += y;
        xEnd += x;
        yEnd += y;
    }

}

