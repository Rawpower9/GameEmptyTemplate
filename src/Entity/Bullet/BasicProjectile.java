package Entity.Bullet;

import Simulator.Position;
import Simulator.Sprite;

public abstract class BasicProjectile {
    public abstract boolean move();
    public abstract int hasCollided();
    public abstract Sprite getSprite();

    public abstract Position getPosition();

    public abstract boolean hasGoneOffScreen();
    public abstract int getCash();
}
