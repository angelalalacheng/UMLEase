import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DrawPanel extends JPanel {
    private ArrayList <Component> components = new ArrayList<>();
    private ArrayList <Component> selectedComponents = new ArrayList<>();
    private int startX, startY, endX, endY;
    private PortComponent closestStartPort, closestEndPort;

    public DrawPanel(ButtonListener buttonListener, EditListener editListener) {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (buttonListener.getMode().equals("Select")) {
                    new SelectFunction(e.getX(), e.getY(), 0, 0, components, selectedComponents).selectOneComponent();
                    repaint();

                    if(editListener.getMode().equals("ChangeName")){
                        selectedComponents.get(0).setName(editListener.getObjectName());
                        repaint();
                        editListener.setMode("noTrigger");
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();


                if (buttonListener.getIsPressed()){
                    switch (buttonListener.getMode()) {
                        case "Class":
                            addComponent(new ClassComponent(startX, startY));
                            break;
                        case "UseCase":
                            addComponent(new UseCaseComponent(startX, startY));
                            break;
                        case "CompositionLine":
                            closestStartPort = findClosestPort(startX, startY);
                            closestEndPort = findClosestPort(endX, endY);
                            CompositionLine compositionLine = new CompositionLine(closestStartPort.getPort().x, closestStartPort.getPort().y, closestEndPort.getPort().x, closestEndPort.getPort().y);
                            addComponent(compositionLine);
                            closestStartPort.addConnection(compositionLine);
                            closestEndPort.addConnection(compositionLine);
                            break;
                        case "GeneralizationLine":
                            closestStartPort = findClosestPort(startX, startY);
                            closestEndPort = findClosestPort(endX, endY);
                            GeneralizationLine generalizationLine = new GeneralizationLine(closestStartPort.getPort().x, closestStartPort.getPort().y, closestEndPort.getPort().x, closestEndPort.getPort().y);
                            addComponent(generalizationLine);
                            closestStartPort.addConnection(generalizationLine);
                            closestEndPort.addConnection(generalizationLine);
                            break;
                        case "AssociationLine":
                            closestStartPort = findClosestPort(startX, startY);
                            closestEndPort = findClosestPort(endX, endY);
                            AssociationLine associationLine = new AssociationLine(closestStartPort.getPort().x, closestStartPort.getPort().y, closestEndPort.getPort().x, closestEndPort.getPort().y);
                            addComponent(associationLine);
                            closestStartPort.addConnection(associationLine);
                            closestEndPort.addConnection(associationLine);
                            break;
                        case "Select":
                            new SelectFunction(startX, startY, endX, endY, components, selectedComponents).selectComponents();
                            repaint();
                            break;
                        default:
                            break;
                    }
                }

                if (editListener.getMode().equals("Group")) {
                    new GroupFunction(components, new SelectFunction(startX, startY, 0, 0, components, selectedComponents).getSelectedComponents()).groupComponents();
                    repaint();
                    editListener.setMode("noTrigger");
                }
                else if (editListener.getMode().equals("Ungroup")) {
                    new UngroupFunction(startX, startY, components);
                    repaint();
                    editListener.setMode("noTrigger");
                }
                else{
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endX = e.getX();
                endY = e.getY();

                if (buttonListener.getMode().equals("Select")) {
                    if (selectedComponents.isEmpty()) {
                        //System.out.println("No components selected");
                        return;
                    }
                    for (Component c : selectedComponents) {
                        int dx = endX - startX;
                        int dy = endY - startY;

                        c.move(dx, dy);

                        startX = endX; //中繼點
                        startY = endY;
                    }
                }
                repaint();
            }
        });
    }

    public void addComponent(Component component) {
        components.add(component);
        component.setOrder(components.size());
        repaint();
    }

    public PortComponent findClosestPort(int x, int y) {
        PortComponent closestPort;
        double closestDistance = Double.MAX_VALUE;

        for (Component c : components) {
            if (c.getBound().contains(x, y)) {
                closestPort = new PortComponent(new Point(0, 0));

                for (PortComponent port : c.getPorts()) {
                    double distance = new Point(x, y).distance(port.getPort());
                    if (distance < closestDistance) {
                        closestDistance = distance;
                        closestPort = port;
                    }
                }
                return closestPort;
            }
        }
        return null;
    }

    public Component findComponent(int x, int y) {
        for (Component c : components) {
            if (c.getBound().contains(x, y)) {
                return c;
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Component c : components) {
            c.draw(g2d);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
}
