import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Component {
    private int order = 0;
    private String name = "object";
    private boolean selected = false;
    private boolean isGroupComponent = false;
    public Component() {
    }

    public void draw(Graphics2D g2d) {
    }

    public void move (int dx, int dy) {}

//    public ArrayList<Point> getPorts() {
//        return new ArrayList<Point>();
//    }
    public ArrayList<PortComponent> getPorts() {
        return new ArrayList<PortComponent>();
    }

    public Rectangle2D getBound() {
        return new Rectangle2D.Double(0, 0, 0, 0);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setIsGroupComponent(boolean isGroupComponent) {
        this.isGroupComponent = isGroupComponent;
    }

    public boolean getIsGroupComponent() {
        return isGroupComponent;
    }
}
