package view;

import object.GroupComponent;
import object.PortComponent;
import object.UMLElement;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Canvas extends JPanel {
    private static ArrayList<UMLElement> Elements = new ArrayList<>();
    public void addElement(UMLElement ele) {
        Elements.add(ele);
        ele.setOrder(Elements.size());
        repaint();
    }
    public void addGroupElement(ArrayList<UMLElement> selected) {
        GroupComponent group = new GroupComponent();
        for (UMLElement c : selected) {
            group.addComponent(c);
            c.setSelected(false);
            Elements.remove(c);
        }
        group.setSelected(true);
        group.setIsGroupComponent(true);
        group.setOrder(Elements.size());
        Elements.add(group);
        System.out.println("After group Elements size: " + Elements.size());
        repaint();
    }
    public void removeElement(UMLElement c) {
        for (UMLElement c1 : ((GroupComponent) c).getGroupComponents()) {
            c1.setSelected(true);
            addElement(c1);
        }
        c.setSelected(false);
        Elements.remove(c);
        System.out.println("After group Elements size: " + Elements.size());
        repaint();
    }
    public void setAllElementStatus(boolean selected) {
        for (UMLElement c : Elements) {
            c.setSelected(selected);
        }
    }
    public void selectOneComponent(int X, int Y){
        ArrayList<UMLElement> selectedTmp = new ArrayList<>();
        setAllElementStatus(false);

        for (UMLElement c : Elements) {
            if (c.getBound().contains(X, Y)) { // check if mouse click is within component
                selectedTmp.add(c);
            }
        }

        if(selectedTmp.size() == 0) {
            return;
        }

        if (selectedTmp.size() > 1) {
            selectedTmp=handleOverlapping(selectedTmp);
        }

        selectedTmp.get(0).setSelected(true);
    }
    public void selectComponents(Point press, Point release){
        int xCor = Math.min(press.x, release.x);
        int yCor = Math.min(press.y, release.y);
        int width = Math.abs(press.x - release.x);
        int height = Math.abs(press.y - release.y);

        Rectangle2D groupArea = new Rectangle2D.Double(xCor, yCor, width, height);
        for (UMLElement c : Elements) {
            if (groupArea.contains(c.getBound())) {
                c.setSelected(true);
            }
        }
    }
    public ArrayList<UMLElement> getSelectedComponents() {
        ArrayList<UMLElement> selectedComponents = new ArrayList<>();
        for (UMLElement c : Elements) {
            if (c.getSelected()) {
                selectedComponents.add(c);
            }
        }
        return selectedComponents;
    }
    public void groupSelectedComponents() {
        ArrayList<UMLElement> selectedComponents = getSelectedComponents();
        System.out.println("Grouping " + selectedComponents.size());
        if (selectedComponents.size() > 1) {
            addGroupElement(selectedComponents);
        }
    }
    public void ungroupSelectedComponents() {
        ArrayList<UMLElement> selectedComponents = getSelectedComponents();
        for (UMLElement c : selectedComponents) {
            if (c.getIsGroupComponent()) {
                removeElement(c);
            }
        }
    }
    public ArrayList<UMLElement> handleOverlapping (ArrayList<UMLElement> selectedComponents) {
        int upper=Integer.MIN_VALUE;
        UMLElement upperComponent = new UMLElement();

        for (UMLElement c : selectedComponents) {
            if (c.getOrder() > upper) {
                upper = c.getOrder();
                upperComponent = c;
            }
        }
        selectedComponents.clear();
        selectedComponents.add(upperComponent);
        return selectedComponents;
    }
    public PortComponent findClosestPort(int x, int y) {
        PortComponent closestPort;
        double closestDistance = Double.MAX_VALUE;

        for (UMLElement c : Elements) {
            if (c.getBound().contains(x, y)) {
                closestPort = new PortComponent(new Point(0, 0), -1);

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
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (UMLElement c : Elements) {
            c.draw(g2d);
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }
}
