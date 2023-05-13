import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ConnectionComponent extends Component {
    private int xStart, yStart, xEnd, yEnd;
// record two object -> if drag A -> judge start or end -> update start point or end point
    public ConnectionComponent(int xStart, int yStart, int xEnd, int yEnd) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawLine(xStart, yStart, xEnd, yEnd);
    }

    public Rectangle2D getBound() {
        return new Rectangle2D.Double(xEnd, yEnd, Math.abs(xEnd-xStart), Math.abs(yEnd-yStart));
    }

    public void move(int x, int y) {
        xStart += x;
        yStart += y;
        xEnd += x;
        yEnd += y;
    }

}
