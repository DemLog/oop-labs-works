package site.dlsky.lab04.components;

import java.util.Arrays;
import java.util.List;

public class HorizontalLayout extends Component {
    private final List<Component> components;

    public HorizontalLayout(Component... components) {
        this.components = Arrays.asList(components);
    }

    @Override
    public void calculate() {
        int x = getX() + 1;
        int y = getY() + 1;
        int maxHeight = 0;

        for (Component component : components) {
            component.setX(x);
            component.setY(y);

            component.calculate();

            x += component.getWidth() + 1;

            maxHeight = Math.max(maxHeight, component.getHeight());
        }

        setWidth(x - getX() - 1);
        setHeight(maxHeight + 2);
    }

    @Override
    public void draw(char[][] buffer) {
        for (Component component : components) {
            component.draw(buffer);
        }
    }
}