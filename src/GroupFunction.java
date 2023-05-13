import java.util.ArrayList;

public class GroupFunction {
    private int count = 0;
    private ArrayList<Component> components;
    private ArrayList<Component> selectedComponents;

    public GroupFunction(ArrayList<Component> components, ArrayList<Component> selectedComponents) {
        this.components = components;
        this.selectedComponents = selectedComponents;

        System.out.println("GroupFunction: num of selected components: " + selectedComponents.size());
        System.out.println("GroupFunction: num of components: " + components.size());
    }

    public void groupComponents() {
        if (selectedComponents.size() > 1) { // only group if more than one component is selected
            GroupComponent groupComponent = new GroupComponent();
            for (Component c : selectedComponents) {
                c.setSelected(false);
                groupComponent.addComponent(c);
                components.remove(c); // remove component from main list after adding to group
                System.out.println("each depth: "+c.getOrder());
            }
            groupComponent.setIsGroupComponent(true);
            components.add(groupComponent); // add group to main list
            selectedComponents.clear(); // clear selected components list
        }
        System.out.println("#GroupFunction: num of selected components: " + selectedComponents.size());
        System.out.println("#GroupFunction: num of components: " + components.size());
    }
}