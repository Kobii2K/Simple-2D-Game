package Entity;

import Core.Game;
import Core.Position;
import Core.Size;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;

    public GameObject(Position p, Size s) {
        position = p;
        size = s;
    }

    public GameObject() {

    }

    public abstract void update();
    public abstract Image getSprite();
    public abstract Position getPosition();
}
