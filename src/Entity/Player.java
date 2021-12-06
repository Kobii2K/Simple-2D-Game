package Entity;

import Controller.Controller;
import Core.Game;
import Core.Position;
import Core.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

    private final Controller controller;
    double deltaY = 0;
    double deltaX = 0;
    public Player(Controller controller) {
        super(new Position(375, -200), new Size(50, 50));
        this.controller = controller;
    }

    public int horizontalCollision(Rectangle playerHitBox, Rectangle groundHitBox, double deltaY) {
        if (playerHitBox.intersects(groundHitBox)) {
            playerHitBox.y -= (int) deltaY;
            while (!playerHitBox.intersects(groundHitBox)) {
                playerHitBox.y++;
            }
            return (playerHitBox.y - 1);
        }
        return 10000;
    }

    @Override
    public void update() {
        deltaY +=0.4;
        deltaX = 0;

        Ground ground = Game.getGround();
        Rectangle playerHitBox = new Rectangle((int) position.getX(), (int) position.getY() + (int) deltaY, size.getLargeur(), size.getLongueur());
        Rectangle groundHitBox = new Rectangle((int) ground.position.getX(), (int) ground.position.getY(), ground.size.getLargeur(), ground.size.getLongueur());

        int y = horizontalCollision(playerHitBox, groundHitBox, deltaY);
        if (y == 10000) {
            y = (int)position.getY();
        } else {
            deltaY = 0;
        }

        //if (controller.isRequestingDown()) {}

        if (controller.isRequestingUp()) {
            if (playerHitBox.intersects(groundHitBox)) {
                double yspeed = 8;
                deltaY = -yspeed;
            }
        }
        double xspeed = 5;
        if (controller.isRequestingLeft()) {
            deltaX -= xspeed;
        }
        if (controller.isRequestingRight()) {
            deltaX += xspeed;
        }
        position = new Position(position.getX() + deltaX, y + deltaY);
    }

    @Override
    public Image getSprite() {
        BufferedImage img = new BufferedImage(size.getLargeur(), size.getLongueur(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, size.getLargeur(), size.getLongueur());
        graphics.dispose();
        return img;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
