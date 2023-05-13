import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditListener implements ActionListener {
    private String mode = "noTrigger";
    private String objectName = "";

    public EditListener() {
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        mode = e.getActionCommand();
        System.out.println("EditListener: " + mode);

        if (mode.equals("ChangeName")) {
            RenameFunction renameFunction = new RenameFunction();
            objectName = renameFunction.getNewName();
            System.out.println("##newName: "+renameFunction.getNewName());
        }
    }

    public String getMode() {
        return mode;
    }

    public void setMode (String mode) {
        this.mode = mode;
    }

    public String getObjectName() {
        return objectName;
    }
}
