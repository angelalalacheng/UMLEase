import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class GroupComponent extends Component implements Group{
    private ArrayList<Component> groupComponents = new ArrayList<Component>();
    private ArrayList<Point> ports = new ArrayList<Point>();
    private Rectangle2D  bound = new Rectangle2D.Double();

    public GroupComponent() {}

    public void addComponent(Component component) {
        groupComponents.add(component);
        updateBound();
    }
    public ArrayList<Component> getGroupComponents() {
        return groupComponents;
    }

    public void draw(Graphics2D g2) {
        for (Component c : groupComponents) {
            c.draw(g2);
        }

        if (getSelected()) {
            showPorts(g2);
        }
    }

    public void updateBound() {
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (Component c : groupComponents) {
            Rectangle2D r = c.getBound();
            if (r.getMinX() < minX) {
                minX = (int) r.getMinX();
            }
            if (r.getMinY() < minY) {
                minY = (int) r.getMinY();
            }
            if (r.getMaxX() > maxX) {
                maxX = (int) r.getMaxX();
            }
            if (r.getMaxY() > maxY) {
                maxY = (int) r.getMaxY();
            }
        }
        bound.setRect(minX, minY, maxX - minX, maxY - minY);
        setPorts();
    }

    public Rectangle2D getBound() {
        return bound;
    }

    public void setPorts() {
        ports.clear();

        ports.add(new Point((int) bound.getCenterX(), (int) bound.getMinY())); //N
        ports.add(new Point((int) bound.getMaxX(), (int) bound.getCenterY())); //E
        ports.add(new Point((int) bound.getCenterX(), (int) bound.getMaxY())); //S
        ports.add(new Point((int) bound.getMinX(), (int) bound.getCenterY())); //W
    }

    public void showPorts (Graphics2D g2d) {
        for (Point p : ports) {
//            g2d.setColor(Color.RED);
            g2d.fillRect(p.x, p.y, 5, 5);
        }
    }

    public void move(int x, int y) {
        for (Component c : groupComponents) {
            c.move(x, y);
        }
        updateBound();
    }
}
