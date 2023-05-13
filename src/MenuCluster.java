import javax.swing.*;

public class MenuCluster {
    private JFrame frame;
    private JPanel panel;
    private EditListener editListener;
    private JMenuBar menuBar;
    private JMenu fileMenu, editMenu;
    private JMenuItem group, ungroup, changeName;
// panel 做了什麼事跟edit listener説
    public MenuCluster(JPanel panel, EditListener editListener, JFrame frame) {
        this.panel = panel;
        this.editListener = editListener;
        this.frame = frame;

        setMenu();
    }

    private void setMenu() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        group = new JMenuItem("Group");
        ungroup = new JMenuItem("Ungroup");
        changeName = new JMenuItem("ChangeName");

        setMenuListener();

        editMenu.add(group);
        editMenu.add(ungroup);
        editMenu.add(changeName);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        panel.add(menuBar);
        frame.setJMenuBar(menuBar);
    }

    private void setMenuListener() {
        group.addActionListener(editListener);
        ungroup.addActionListener(editListener);
        changeName.addActionListener(editListener);
    }
}
