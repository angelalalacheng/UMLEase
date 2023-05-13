import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class SelectFunction {
    private int startX, startY, endX, endY;
    private ArrayList<Component> components;
    private ArrayList<Component> selectedComponents;

    public SelectFunction(int startX, int startY, int endX, int endY, ArrayList<Component> components, ArrayList<Component> selectedComponents){
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.components = components;
        this.selectedComponents = selectedComponents;
    }

    public void selectOneComponent(){
        if (selectedComponents.size() > 0) {
            selectedComponents.clear();
        }

        for (Component c : components) {
            if (c.getBound().contains(startX, startY)) { // check if mouse click is within component
                if (!c.getSelected()) { // check if component has been clicked on
                    c.setSelected(true);
                    selectedComponents.add(c);
                } else {
                    c.setSelected(false);
                }
            }
            else {
                c.setSelected(false); // only one component can be selected at a time
            }
        }
        System.out.println("Selected components: " + selectedComponents);

        if (selectedComponents.size() > 1) {
            selectedComponents = handleOverlapping(selectedComponents);
        }

        System.out.println("#Selected components: " + selectedComponents);
    }

    public void selectComponents() {
        int xCor = Math.min(startX, endX);
        int yCor = Math.min(startY, endY);
        int width = Math.abs(startX - endX);
        int height = Math.abs(startY - endY);

        Rectangle2D groupArea = new Rectangle2D.Double(xCor, yCor, width, height);
        for (Component c : components) {
            if (groupArea.contains(c.getBound())) {
                c.setSelected(true);
                selectedComponents.add(c);
            }
            else {
                c.setSelected(false);
            }
        }
    }

    public ArrayList<Component> getSelectedComponents() {
        return selectedComponents;
    }

    public boolean isOverlapping(Component c1, Component c2) {
        Rectangle2D c1Bounds = c1.getBound();
        Rectangle2D c2Bounds = c2.getBound();
        return c1Bounds.intersects(c2Bounds);
    }

    public ArrayList<Component> handleOverlapping (ArrayList<Component> selectedComponents) {

        for (Component c1 : selectedComponents) {
            for (Component c2 : selectedComponents) {
                if (c1 != c2 && isOverlapping(c1, c2)) {
                    if (c1.getOrder() > c2.getOrder()) {
                        c2.setSelected(false);
                        selectedComponents.remove(c2);
                    }
                    else {
                        c1.setSelected(false);
                        selectedComponents.remove(c1);
                    }
                }
            }
        }
        return selectedComponents;
    }
}
