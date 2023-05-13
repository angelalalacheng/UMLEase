import javax.swing.*;

public class RenameFunction {
    private JFrame frame = new JFrame();
    private boolean okPressed = false;
    private String newName = "";
    public RenameFunction() {
        newName = JOptionPane.showInputDialog(frame, "Enter new object name:");
        if (newName != null) {
            okPressed = true;
        }
        System.out.println("newName: "+newName);
        System.out.println("okPress: "+isOkPressed());
    }

    public boolean isOkPressed() {
        return okPressed;
    }

    public String getNewName() {
        return newName;
    }
}
