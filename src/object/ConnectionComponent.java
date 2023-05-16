package object;

import java.awt.*;
import java.awt.Component;
import java.awt.geom.Rectangle2D;

public class ConnectionComponent extends UMLElement {
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

//    public Rectangle2D getBound() {
//        return new Rectangle2D.Double(xEnd, yEnd, Math.abs(xEnd-xStart), Math.abs(yEnd-yStart));
//    }

    public void move(int xS, int yS, int xE, int yE) {
        // 希望move的時候，只有start or end會動(select object)
        // move都動(select group object)

        xStart += xS;
        yStart += yS;
        xEnd += xE;
        yEnd += yE;
    }

}
