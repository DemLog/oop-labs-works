package site.dlsky.lab04.components;

public class Rectangle extends Component {
    private final Component innerComponent;

    public Rectangle(Component nestedComponent) {
        this.innerComponent = nestedComponent;
    }

    @Override
    public void calculate() {
        // Вычисляем размеры вложенного элемента и добавляем отступы и рамку
        int nestedWidth = innerComponent.getWidth() + 2;
        int nestedHeight = innerComponent.getHeight() + 2;
        setWidth(nestedWidth);
        setHeight(nestedHeight);
    }

    @Override
    public void draw(char[][] buffer) {
        // Рисуем рамку вокруг вложенного элемента
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();

        // Верхняя и нижняя горизонтальные линии
        for (int i = x; i < x + width; i++) {
            buffer[i][y] = '-';
            buffer[i][y + height - 1] = '-';
        }

        // Левая и правая вертикальные линии
        for (int i = y + 1; i < y + height - 1; i++) {
            buffer[x][i] = '|';
            buffer[x + width - 1][i] = '|';
        }

        // Заполняем внутренность пробелами
        for (int i = y + 1; i < y + height - 1; i++) {
            for (int j = x + 1; j < x + width - 1; j++) {
                buffer[j][i] = ' ';
            }
        }

        // Отрисовываем вложенный элемент внутри рамки
        innerComponent.draw(buffer);
    }
}
