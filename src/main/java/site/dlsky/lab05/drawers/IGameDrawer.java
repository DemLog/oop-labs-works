package site.dlsky.lab05.drawers;

import site.dlsky.lab05.models.Area;
import site.dlsky.lab05.models.Ball;

public interface IGameDrawer {
    void printTable(Area area);

    void printBall(Ball ball);

    void printMessage(String message);
}
