package site.dlsky.lab04.components;

import java.util.Arrays;
import java.util.List;

public class VerticalLayout extends Component {
    private final List<Component> components;

    public VerticalLayout(Component... components) {
        this.components = Arrays.asList(components);
    }

    public void addChild(Component child) {
        components.add(child);
    }

    public void removeChild(Component child) {
        components.remove(child);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public void calculate() {
        int maxWidth = 0;
        int totalHeight = 0;

        for (Component child : components) {
            child.setX(getX());
            child.setY(getY() + totalHeight);

            child.calculate();

            if (child.getWidth() > maxWidth) {
                maxWidth = child.getWidth();
            }

            totalHeight += child.getHeight();
        }

        setWidth(maxWidth);
        setHeight(totalHeight);
    }

    @Override
    public void draw(char[][] buffer) {
        for (Component child : components) {
            child.draw(buffer);
        }
    }
}
