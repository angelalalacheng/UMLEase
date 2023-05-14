package mode;

import view.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectMode extends Mode{
    private Point pressPoint, releasePoint;
    @Override
    public void mouseClicked(MouseEvent e) {
        Canvas canvas = (Canvas) e.getSource();
        canvas.selectOneComponent(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        releasePoint = new Point(e.getX(), e.getY());
        Canvas canvas = (Canvas) e.getSource();
        canvas.selectComponents(pressPoint, releasePoint);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Canvas canvas = (Canvas) e.getSource();

        releasePoint = new Point(e.getX(), e.getY());

        System.out.println("SelectMode mouseDragged releasePoint: " + releasePoint.x + ", " + releasePoint.y);
        canvas.getSelectedComponents().forEach(component -> {
            int dx = releasePoint.x - pressPoint.x;
            int dy = releasePoint.y - pressPoint.y;
            component.move(dx,  dy);
            pressPoint = releasePoint;//中繼點
        });
    }
}
