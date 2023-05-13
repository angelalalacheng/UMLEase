import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Your UML Diagram");
        ButtonListener buttonListener = new ButtonListener();
        EditListener editListener = new EditListener();
        DrawPanel panel = new DrawPanel(buttonListener, editListener);
        JMenuBar menuBar = new JMenuBar();
        ButtonCluster buttonCluster = new ButtonCluster(panel, buttonListener);
        MenuCluster menuCluster = new MenuCluster(panel, editListener, frame);


        frame.setLayout(new BorderLayout());
        frame.add(panel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}

// to do
// 1. add diff connection line V
// 2. judge the connection line is on valid port or not V
// 3. judge the depth of the component V
// 4. set object name V
// 5. bug: can not move the group component V
// does the connection lines need the bound? no
// bug: line will connect to 0,0 when the mouse is not on the port
// bug: move object but line not move
// bug: group more than 3 objects can not move all V