package Controller;

import Input.Input;
import java.awt.event.KeyEvent;

public class PlayerController implements Controller{

    private Input input;

    public PlayerController(Input input) {
        this.input = input;
    }

    @Override
    public boolean isRequestingDown() {
        return (input.isPressed(KeyEvent.VK_S) || input.isPressed(KeyEvent.VK_DOWN));
    }
    @Override
    public boolean isRequestingUp() {
        return (input.isPressed(KeyEvent.VK_Z) || input.isPressed(KeyEvent.VK_UP));
}
    @Override
    public boolean isRequestingLeft() {
        return (input.isPressed(KeyEvent.VK_Q) || input.isPressed(KeyEvent.VK_LEFT));
    }
    @Override
    public boolean isRequestingRight() {
        return (input.isPressed(KeyEvent.VK_D) || input.isPressed(KeyEvent.VK_RIGHT));
    }
}
