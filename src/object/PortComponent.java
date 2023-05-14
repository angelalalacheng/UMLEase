package object;

import java.awt.*;
import java.util.ArrayList;

public class PortComponent {
    private ArrayList<ConnectionComponent> connections = new ArrayList<ConnectionComponent>();
    private Point port;

    public PortComponent(Point port) {
        this.port = port;
    }

    public void addConnection(ConnectionComponent connection) {
        connections.add(connection);
    }

    public void move(int x, int y) {
        port.x += x;
        port.y += y;
        for (ConnectionComponent connection : connections) {
            connection.move(x, y);
        }
    }

    public ArrayList<ConnectionComponent> getConnections() {
        return connections;
    }

    public Point getPort() {
        return port;
    }
}
