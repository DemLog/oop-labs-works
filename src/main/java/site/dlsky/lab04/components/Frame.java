package site.dlsky.lab04.components;

public class Frame extends Component {
    private final String title;
    private final Component innerComponent;

    public Frame(String title, Component innerComponent) {
        this.title = title;
        this.innerComponent = innerComponent;
    }

    @Override
    public void calculate() {
        innerComponent.calculate();
        setWidth(innerComponent.getWidth() + 2);
        setHeight(innerComponent.getHeight() + 2);
    }

    @Override
    public void draw(char[][] buffer) {
        for (int i = 0; i < getWidth(); i++) {
            buffer[getX() + i][getY()] = '═';
            buffer[getX() + i][getY() + getHeight() - 1] = '═';
        }
        for (int i = 1; i < getHeight() - 1; i++) {
            buffer[getX()][getY() + i] = '║';
            buffer[getX() + getWidth() - 1][getY() + i] = '║';
        }

        for (int i = 0; i < title.length(); i++) {
            buffer[i + 1][getY()] = title.charAt(i);
        }

        innerComponent.draw(buffer);
    }
}