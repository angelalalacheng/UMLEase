package mode;

import java.awt.event.MouseEvent;
import view.Canvas;
import object.ClassComponent;

public class ClassMode extends Mode{
    @Override
    public void mouseClicked(MouseEvent e) {
        Canvas canvas = (Canvas) e.getSource();
        canvas.addElement(new ClassComponent(e.getX(), e.getY()));
    }
}
