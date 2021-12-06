package Display;

import Core.Game;
import Core.Size;
import Entity.GameObject;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Canva extends java.awt.Canvas {

    public Canva(int largeur, int longueur) {
        setPreferredSize(new Dimension(largeur, longueur));
        setBackground(Color.decode("#1a001a"));
        setFocusable(false);
    }

    public void render(Game game) {
        BufferStrategy bufferStrategy = getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.decode("#1a001a"));
        graphics.fillRect(0, 0, getWidth(), getHeight());

        for (GameObject objet : game.getGameObjects()) {
            graphics.drawImage(objet.getSprite(), (int)objet.getPosition().getX(), (int)objet.getPosition().getY(), null);
        }

        graphics.dispose();
        bufferStrategy.show();
    }
}
