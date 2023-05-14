package mode;

import view.Canvas;

import java.awt.event.MouseEvent;
import object.UseCaseComponent;

public class UseCaseMode extends Mode{
    @Override
    public void mouseClicked(MouseEvent e) {
        Canvas canvas = (Canvas) e.getSource();
        canvas.addElement(new UseCaseComponent(e.getX(), e.getY()));
    }
}
