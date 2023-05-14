package mode;

import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Mode implements MouseInputListener{
    private static Mode currentMode;

    public static Mode getCurrentMode() {
        System.out.println("### currentMode: " + currentMode);
        return currentMode;
    }

    public static void setCurrentMode(Mode mode) {
        currentMode = mode;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
