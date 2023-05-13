import java.util.ArrayList;

public class UngroupFunction {
    // judge whether it is a group component
    // if it is, ungroup it
    // if not, do nothing
    private ArrayList<Component> components;

    private int startX, startY;

    public UngroupFunction(int startX, int startY, ArrayList<Component> components) {
        this.startX = startX;
        this.startY = startY;
        this.components = components;

        checkGroupComponent();
    }

    public void checkGroupComponent() {
        for (Component c : components) {
            if (c.getIsGroupComponent() && c.getBound().contains(startX, startY)) {
                ungroupComponents(c);
            }
        }
    }

    public void ungroupComponents(Component c) {
        GroupComponent groupComponent = (GroupComponent) c;
        ArrayList<Component> groupComponents = groupComponent.getGroupComponents();

//        for(int i = 0; i < groupComponents.size(); i++) {
//            groupComponents.get(i).setIsGroupComponent(false);
//            System.out.println("#each depth: "+ groupComponents.get(i).getDepth());
//            components.add(groupComponents.get(i));
//        }
        for (Component gc : groupComponents) {
            gc.setIsGroupComponent(false);
            System.out.println("#each depth: "+ gc.getOrder());
            components.add(gc);
        }
        components.remove(c);

        System.out.println("#UngroupFunction: num of components: " + components.size());
        System.out.println(components);
    }
}
