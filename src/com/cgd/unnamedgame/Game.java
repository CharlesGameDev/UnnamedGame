package com.cgd.unnamedgame;

import com.cgd.unnamedgame.constants.Constants;

import java.awt.*;
import java.awt.image.BufferStrategy;

import com.cgd.unnamedgame.debug.Debug;
import com.cgd.unnamedgame.display.Window;
import com.cgd.unnamedgame.input.Keyboard;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean running;

    private final Handler handler;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new Keyboard(handler));

        new Window(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, Constants.GAME_NAME, this);

        Player player = new Player(Constants.WINDOW_WIDTH / 2, Constants.WINDOW_HEIGHT / 2);
        player.position.x -= 32;
        player.position.y -= 32;
        handler.addObject(player);

        handler.start();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double ns = (double)1000000000 / Constants.TARGET_FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int fps = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick(delta);
                delta--;
            }
            if (running)
                render();
            fps++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                Debug.Log("FPS: " + fps);
                fps = 0;
            }
        }
        stop();
    }

    private void tick(double deltaTime) {
        handler.tick(deltaTime);
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT); // Create black background

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }

}
