package site.dlsky.lab05.drawers;

import site.dlsky.lab05.models.Area;
import site.dlsky.lab05.models.Ball;
import site.dlsky.lab05.models.Field;
import site.dlsky.lab05.service.BallColor;

public class GameDrawerDef implements IGameDrawer {
    @Override
    public void printTable(Area area) {
        for (int i = 0; i < area.FieldCount; i++) {
            Field field = area.getField(i);
            i++;
            Field field2 = area.getField(i);
            for (int j = 0; j < 3; j++) {
                printLineOfField(field,j);
                printLineOfField(field2,j);
                System.out.print("\n");
            }
        }
    }
    private void printLineOfField(Field field, int j){
        for (int k = 0; k < field.getSize()[0]; k++) {
            printBall(field.getBall(j, k));
        }
    }
    @Override
    public void printBall(Ball ball) {
        if(ball != null) {
            if(ball.state == BallColor.White)
                System.out.print("x");
            else
                System.out.print("o");
        }
        else{
            System.out.print("*");
        }
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}

