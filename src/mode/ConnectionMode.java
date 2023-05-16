package mode;

import object.CompositionLine;
import object.PortComponent;
import object.UMLElement;
import view.Canvas;

import javax.lang.model.util.Elements;
import java.awt.event.MouseEvent;

public class ConnectionMode extends Mode{
    protected int xStart, yStart, xEnd, yEnd;
    // 紀錄和object相連的line->當object移動時，line也要跟著移動
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
