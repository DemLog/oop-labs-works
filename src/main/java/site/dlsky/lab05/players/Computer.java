package site.dlsky.lab05.players;

import site.dlsky.lab05.models.Area;
import site.dlsky.lab05.models.Ball;
import site.dlsky.lab05.models.Field;
import site.dlsky.lab05.service.BallColor;
import site.dlsky.lab05.service.Direction;
import site.dlsky.lab05.service.Point;

import java.util.Random;

public class Computer extends Player {

    @Override
    public Field selectField(Area area) {
        int counter = 0;
        while(true){
            counter++;
            Random rnd = new Random();
            int index = rnd.nextInt(4);
            Field field = area.getField(index);
            if(counter == 100){
                throw new RuntimeException("fields are whole");
            }
            if(!field.isWhole()){
                return field;
            }
        }
    }

    @Override
    public Point selectPosition(Field field) {
        for (int i = 0; i<3; i++)
            for (int j = 0; j<3; j++)
                if(field.getBall(i,j)==null)
                    return new Point(i,j);

        throw new RuntimeException("Field is whole");
    }

    @Override
    public Ball selectBall() {
        return new Ball(BallColor.Black);
    }

    @Override
    public Direction selectDirection() {
        Random rnd = new Random();
        int index = rnd.nextInt(2);
        if(index == 0)
            return Direction.Left;
        else
            return Direction.Right;
    }
}
