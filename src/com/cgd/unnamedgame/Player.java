package com.cgd.unnamedgame;

import com.cgd.unnamedgame.debug.Debug;
import com.cgd.unnamedgame.obj.GameObject;
import com.cgd.unnamedgame.obj.Vector2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends GameObject {

    private Vector2 velocity = Vector2.zero;

    public Player(int x, int y) {
        super(x, y, ID.Player);
    }

    public void start() {
        Debug.Log("Player instantiated");
    }

    public void input(int key, boolean pressed) {
        if (pressed) {
            if (key == KeyEvent.VK_W) velocity.y = 5;
        }
    }

    public void tick(double deltaTime) {
        position.x += velocity.x;
        position.y += velocity.y;
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(position.x, position.y, 32, 32);
    }

}
