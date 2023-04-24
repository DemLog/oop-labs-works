package site.dlsky.lab05.players;

import site.dlsky.lab05.models.Area;
import site.dlsky.lab05.models.Ball;
import site.dlsky.lab05.models.Field;
import site.dlsky.lab05.service.Direction;
import site.dlsky.lab05.service.Point;

public abstract class Player {
    public abstract Field selectField(Area area);
    public abstract Point selectPosition(Field field);
    public abstract Ball selectBall();
    public abstract Direction selectDirection();
}
