package view;

import mode.Mode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModeButton extends JButton implements ActionListener {
    private Mode mode;
    public ModeButton(String text, Mode mode){
        super(text);
        this.mode = mode;
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Mode.setCurrentMode(mode);
        Canvas canvas = (Canvas) this.getParent();
        canvas.setAllElementStatus(false);
    }
}
