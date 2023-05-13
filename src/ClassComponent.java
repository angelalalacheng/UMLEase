import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ClassComponent extends Component {
    private int xCor, yCor;
    private ArrayList<PortComponent> port = new ArrayList<PortComponent>();

    public ClassComponent(int xCor, int yCor) {
        this.xCor = xCor;
        this.yCor = yCor;
        setPorts();
    }

    public void draw(Graphics2D g2d) {
        g2d.drawString(this.getName(), xCor, yCor);
        g2d.drawRect(xCor, yCor, 100, 30);
        g2d.drawRect(xCor, yCor+30, 100, 30);
        g2d.drawRect(xCor, yCor+60, 100, 30);

        if (getSelected()) {
            showPorts(g2d);
        }
    }

    public Rectangle2D getBound() {
        return new Rectangle2D.Double(xCor, yCor, 100, 90);
    }

    public void setPorts() {
        port.add(new PortComponent(new Point(xCor+50, yCor))); //N
        port.add(new PortComponent(new Point(xCor+100, yCor+45))); //E
        port.add(new PortComponent(new Point(xCor+50, yCor+90))); //S
        port.add(new PortComponent(new Point(xCor, yCor+45))); //W
    }

    public void showPorts (Graphics2D g2d) {
        for (PortComponent p : port) {
            g2d.setColor(Color.BLACK);
            g2d.fillRect(p.getPort().x, p.getPort().y, 5, 5);
        }
    }

    public ArrayList<PortComponent> getPorts() {
        return port;
    }

    public void move(int x, int y) {
        xCor += x;
        yCor += y;
        updatePorts(x, y);
    }

    public void updatePorts(int x, int y) {
        for (PortComponent p : port) {
            System.out.println(p);
            p.move(x,y);
        }
    }
}
