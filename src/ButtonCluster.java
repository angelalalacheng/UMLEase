import javax.swing.*;


public class ButtonCluster{
    private JPanel panel;
    private ButtonListener buttonListener;

    private JButton btnClass, btnUseCase, btnAssociationLine, btnCompositionLine, btnGeneralLine, btnSelect;
    public ButtonCluster(JPanel panel, ButtonListener buttonListener) {
        this.panel = panel;
        this.buttonListener = buttonListener;
        setButton();
        setButtonListener();
    }

    private void setButton() {
        btnClass = new JButton("Class");
        btnUseCase = new JButton("UseCase");
        btnAssociationLine = new JButton("AssociationLine");
        btnGeneralLine = new JButton("GeneralizationLine");
        btnCompositionLine = new JButton("CompositionLine");
        btnSelect = new JButton("Select");

        panel.add(btnClass);
        panel.add(btnUseCase);
        panel.add(btnAssociationLine);
        panel.add(btnGeneralLine);
        panel.add(btnCompositionLine);
        panel.add(btnSelect);
    }

    private void setButtonListener() {
        btnClass.addActionListener(buttonListener);
        btnUseCase.addActionListener(buttonListener);
        btnAssociationLine.addActionListener(buttonListener);
        btnCompositionLine.addActionListener(buttonListener);
        btnGeneralLine.addActionListener(buttonListener);
        btnSelect.addActionListener(buttonListener);
    }

}
