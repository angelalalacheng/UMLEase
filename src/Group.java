import java.util.ArrayList;

public interface Group {
    public ArrayList<Component> getGroupComponents();
    public void updateBound();
    public void addComponent(Component component) ;
}
