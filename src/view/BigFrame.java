package view;

import mode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BigFrame extends JFrame {
    private Canvas canvas = new Canvas();
    public BigFrame() {
        initMenu();
        initButton();
        initCanvas();
        initFrame();
    }

    public void initFrame(){
        this.setTitle("UML Editor");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initCanvas() {
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Mode.getCurrentMode().mouseClicked(e);
                canvas.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Mode.getCurrentMode().mousePressed(e);
                canvas.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                Mode.getCurrentMode().mouseReleased(e);
                canvas.repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //Mode.getCurrentMode().mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //Mode.getCurrentMode().mouseExited(e);
            }
        });

        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Mode.getCurrentMode().mouseDragged(e);
                canvas.repaint();
            }
        });

        this.add(canvas, BorderLayout.NORTH);
    }

    public void initButton() {
        ModeButton classButton, useCaseButton, associationButton, generalizationButton, compositionButton, selectButton;
        classButton = new ModeButton("Class", new ClassMode());
        useCaseButton = new ModeButton("UseCase", new UseCaseMode());
        associationButton = new ModeButton("AssociationLine", new AssociationLineMode());
        generalizationButton = new ModeButton("GeneralizationLine", new GeneralizationLineMode());
        compositionButton = new ModeButton("CompositionLine", new CompositionLineMode());
        selectButton = new ModeButton("Select", new SelectMode());

        canvas.add(classButton);
        canvas.add(useCaseButton);
        canvas.add(associationButton);
        canvas.add(generalizationButton);
        canvas.add(compositionButton);
        canvas.add(selectButton);
    }

    public void initMenu(){
        JMenuBar jMenuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem group = new JMenuItem("Group");
        JMenuItem ungroup = new JMenuItem("Ungroup");
        JMenuItem changeName = new JMenuItem("ChangeName");

        group.addActionListener(e -> {
            System.out.println("group");
            canvas.group();
        });
        ungroup.addActionListener(e -> {
            System.out.println("ungroup");
            canvas.ungroup();
        });
        changeName.addActionListener(e -> {
            System.out.println("changeName");
            String newName = JOptionPane.showInputDialog(this, "Enter new object name:");
            canvas.getSelectedComponents().get(0).setName(newName);
            canvas.repaint();
        });

        editMenu.add(group);
        editMenu.add(ungroup);
        editMenu.add(changeName);

        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);

        canvas.add(jMenuBar);

        this.setJMenuBar(jMenuBar);
    }

}
