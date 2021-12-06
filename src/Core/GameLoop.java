package Core;

public class GameLoop implements Runnable{

    private Game game;

    private boolean running;
    private final double updateRate = 1d/60d; //implements a double

    private long nextFpsTime;
    private int fps, ups;

    public GameLoop(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastTime = System.currentTimeMillis();
        nextFpsTime = System.currentTimeMillis() + 1000;

        while (running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastTime) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastTime = currentTime;

            while (accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
            render();
            printFPS();
        }
    }

    private void printFPS() {
        if (System.currentTimeMillis() > nextFpsTime) {
            System.out.println(String.format("FPS : %d, UPS: %d", fps, ups));
            fps = 0; ups = 0;
            nextFpsTime = System.currentTimeMillis() + 1000;
        }
    }
    private void update() {
        game.update();
        fps++;
    }
    private void render() {
        game.render();
        ups++;
    }
}
