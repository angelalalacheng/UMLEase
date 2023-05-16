package object;

import java.awt.*;
import java.util.ArrayList;

public class PortComponent {
    private ArrayList<ConnectionComponent> connections = new ArrayList<ConnectionComponent>();
    private Point port;
    private int portType = 0;// 0: start, 1: end, -1: initial

    public PortComponent(Point port, int portType) {
        this.port = port;
        this.portType = portType;
    }

    public void addConnection(ConnectionComponent connection) {
        connections.add(connection);
    }

    public void move(int x, int y) {
        port.x += x;
        port.y += y;
        System.out.println("moving port: " + port.x + ", " + port.y);
        System.out.println("connections: " + connections.size());
        for (ConnectionComponent connection : connections) {
            System.out.println("moving connection: " + connection);
            connection.move(x, y);
        }
    }

    public ArrayList<ConnectionComponent> getConnections() {
        return connections;
    }

    public Point getPort() {
        return port;
    }

    public void setPortType(int portType) {
        this.portType = portType;
    }
}
