    package Entity;

import Core.Position;
import Core.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ground extends GameObject{

    public Ground() {
        super(new Position(-10, 425), new Size(820, 200));
    }
    @Override
    public void update() {
    }

    @Override
    public Image getSprite() {
        BufferedImage img = new BufferedImage(size.getLargeur(), size.getLongueur(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = img.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, size.getLargeur(), size.getLongueur());
        graphics.dispose();
        return img;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
