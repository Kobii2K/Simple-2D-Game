package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

    private final boolean[] inputs;

    public Input() {
        inputs = new boolean[255];
    }

    public boolean isPressed(int key) {
        return inputs[key];
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        inputs[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        inputs[e.getKeyCode()] = false;
    }
}
