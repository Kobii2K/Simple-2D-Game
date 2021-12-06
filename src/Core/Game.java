package Core;
import Controller.PlayerController;
import Display.Canva;
import Display.JFrameWindow;
import Entity.GameObject;
import Entity.Ground;
import Entity.Player;
import Input.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<GameObject> gameObjects;
    private final JFrameWindow window;
    private final Canva canva;
    private final Input input;
    public Ground ground;

    public Game(int largeur, int longueur) {
        this.input = new Input();
        this.window = new JFrameWindow(largeur, longueur, input);
        this.canva = window.canva;
        this.gameObjects = new ArrayList<>();
        this.gameObjects.add(new Player(new PlayerController(input)));
        this.gameObjects.add(ground = new Ground());
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void update() {
        for (GameObject objet : this.gameObjects) {
            objet.update();
        }
    }

    public void render() {
        window.canva.render(this);
    }
}
