package Entity;

import Controller.Controller;
import Core.Position;
import Core.Size;
import Display.Canva;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject{

    private Controller controller;
    private double xspeed = 5;
    private double yspeed = 8;
    double deltaY = 0;
    double deltaX = 0;
    public Player(Controller controller) {
        super(new Position(375, 450), new Size(50, 50));
        this.controller = controller;
    }

    public boolean checkCollisions() {
        Rectangle p = new Rectangle((int)position.getX(), (int)position.getY(), size.getLargeur(), size.getLongueur());
        return true;
    }

    @Override
    public void update() {
        if (checkCollisions()) {
            deltaX = 0;
            deltaY += 0.5;

            if (controller.isRequestingDown()) {
                deltaY += 1;
            }
            if (controller.isRequestingUp()) {
                deltaY = -yspeed;
            }
            if (controller.isRequestingLeft()) {
                deltaX -= xspeed;
            }
            if (controller.isRequestingRight()) {
                deltaX += xspeed;
            }
            position = new Position(position.getX() + deltaX, position.getY() + deltaY);
        }
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
