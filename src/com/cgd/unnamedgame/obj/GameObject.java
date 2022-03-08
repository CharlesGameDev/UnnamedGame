package com.cgd.unnamedgame.obj;

import com.cgd.unnamedgame.ID;

import java.awt.*;

public abstract class GameObject {

    public Vector2 position;
    protected final ID id;

    public GameObject(Vector2 position, ID id) {
        this.position = position;
        this.id = id;
    }

    public GameObject(int x, int y, ID id) {
        this.position = new Vector2(x, y);
        this.id = id;
    }

    public GameObject(ID id) {
        this.position = Vector2.zero;
        this.id = id;
    }

    public abstract void start();
    public abstract void input(int key, boolean pressed);
    public abstract void tick(double deltaTime);
    public abstract void render(Graphics g);

}
