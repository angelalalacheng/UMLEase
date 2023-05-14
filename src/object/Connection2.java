package object;

import java.awt.*;
import java.awt.Component;

public class Connection2 extends java.awt.Component {
    private java.awt.Component start, end;
    private int startX, startY, endX, endY;
    private Point p1, p2;
    public Connection2(int xStart, int yStart, int xEnd, int yEnd, java.awt.Component start, Component end) {
        this.start = start;
        this.end = end;
        this.startX = xStart;
        this.startY = yStart;
        this.endX = xEnd;
        this.endY = yEnd;

//        p1 = findClosestPort(startX, startY, start);
//        p2 = findClosestPort(endX, endY, end);
    }

    public void draw(Graphics2D g2d) {
        g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

//    public Point findClosestPort(int x, int y, Object.UMLElement c) {
//        Point closestPort = new Point();
//        double closestDistance = Double.MAX_VALUE;
//
//        for (Point port : c.getPorts()) {
//            double distance = new Point(x, y).distance(port);
//            if (distance < closestDistance) {
//                closestDistance = distance;
//                closestPort = port;
//            }
//        }
//
//        return closestPort;
//    }



}
