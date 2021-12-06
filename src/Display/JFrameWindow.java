package Display;

import Core.Size;
import Input.Input;

import javax.swing.*;

public class JFrameWindow extends JFrame {

    public Canva canva;

    public JFrameWindow(int largeur, int longueur, Input input) {
        ImageIcon img = new ImageIcon("src/Ressources/runningMan.png");
        setIconImage(img.getImage());
        setTitle("Yakak");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setUndecorated(true);
        setResizable(false);

        canva = new Canva(largeur, longueur);
        add(canva);
        addKeyListener(input);
        pack(); //calculates the size of JFrame depending on its children(s) (size, position...)

        //finish drawing a screen and draw on another screen and then display the other one
        //So we don't draw on the one and only screen and
        // let the user see the rendering live (flickering cause no image prepared)
        canva.createBufferStrategy(3);

        setLocationRelativeTo(null); //pop the window in the center
        setVisible(true);
    }

}
