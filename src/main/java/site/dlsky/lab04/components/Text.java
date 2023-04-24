package site.dlsky.lab04.components;

public class Text extends Component {
    private final String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public void calculate() {
        setWidth(text.length());
        setHeight(1);
    }

    @Override
    public void draw(char[][] buffer) {
        for (int i = 0; i < text.length(); i++) {
            buffer[getX() + i][getY()] = text.charAt(i);
        }
    }
}
