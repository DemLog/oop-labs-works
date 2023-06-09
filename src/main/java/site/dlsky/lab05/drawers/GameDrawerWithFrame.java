package site.dlsky.lab05.drawers;

import site.dlsky.lab05.models.Area;
import site.dlsky.lab05.models.Ball;
import site.dlsky.lab05.models.Field;

public class GameDrawerWithFrame implements IGameDrawer {

    @Override
    public void printTable(Area area) {
        System.out.println(getUpperLine(6*2+2));
        for (int i = 0; i < area.FieldCount; i++) {
            Field field = area.getField(i);
            i++;
            Field field2 = area.getField(i);
            for (int j = 0; j < 3; j++) {
                System.out.print("║");
                printLineOfField(field,j);
                System.out.print("║");
                printLineOfField(field2,j);
                System.out.print("║");
                System.out.print("\n");
            }
            if(i < area.FieldCount-2){
                System.out.println(getMiddleLine(14));
            }
        }
        System.out.println(getLowerLine(14));
    }
    private void printLineOfField(Field field,int j){
        for (int k = 0; k < field.getSize()[0]; k++) {
            printBall(field.getBall(j, k));
            if(k != field.getSize()[0]-1){
                System.out.print("|");
            }
        }
    }
    private String getUpperLine(int size) {
        return "╔" + getRepeatLine(5, "═") + "╦" +getRepeatLine(5, "═") +"╗" ;
    }

    private String getLowerLine(int size) {
        return "╚"+getRepeatLine(5, "═")+ "╩" + getRepeatLine(5, "═") + "╝";
    }
    private String getMiddleLine(int size){
        return "╠"+getRepeatLine(5, "═") + "╬" +getRepeatLine(5, "═")+ "╣";
    }
    private String getRepeatLine(int size, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++)
            stringBuilder.append(str);
        return stringBuilder.toString();
    }

    @Override
    public void printBall(Ball ball) {
        if (ball != null) {
            System.out.print(ball);
        } else {
            System.out.print(" ");
        }
    }
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
