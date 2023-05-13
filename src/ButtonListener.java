import javax.swing.*;
import java.awt.event.*;

public class ButtonListener implements ActionListener {
    private boolean isPressed = false;
    private String mode;
    public ButtonListener() {
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        isPressed = true;
        mode = e.getActionCommand();
    }

    public boolean getIsPressed() {
        return isPressed;
    }

    public String getMode() {
        return mode;
    }
}