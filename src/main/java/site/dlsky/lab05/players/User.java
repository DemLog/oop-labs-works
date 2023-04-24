package site.dlsky.lab05.players;

import site.dlsky.lab05.models.Area;
import site.dlsky.lab05.models.Ball;
import site.dlsky.lab05.models.Field;
import site.dlsky.lab05.service.BallColor;
import site.dlsky.lab05.service.Direction;
import site.dlsky.lab05.service.Point;

import java.util.Scanner;

public class User extends Player {

    @Override
    public Field selectField(Area area) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        return area.getField(index);
    }

    @Override
    public Point selectPosition(Field field) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] point = line.split(";");
        return new Point(Integer.parseInt(point[0]),Integer.parseInt(point[1]));
    }

    @Override
    public Ball selectBall() {
        return new Ball(BallColor.White);
    }

    @Override
    public Direction selectDirection() {
        Scanner scanner = new Scanner(System.in);
        String color = scanner.nextLine();
        if(color.equals("left") || color.equals("l"))
            return Direction.Left;
        else if(color.equals("right") || color.equals("r"))
            return Direction.Right;
        throw new RuntimeException("inccorect direction");
    }
}
