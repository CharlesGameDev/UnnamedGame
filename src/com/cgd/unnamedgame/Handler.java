package com.cgd.unnamedgame;

import com.cgd.unnamedgame.obj.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    private final LinkedList<GameObject> objects = new LinkedList<>();

    public void start() {
        for (GameObject object : objects) {
            object.start();
        }
    }

    public void input(int key, boolean pressed)
    {
        for (GameObject object : objects) {
            object.input(key, pressed);
        }
    }

    public void tick(double deltaTime) {
        for (GameObject object : objects) {
            object.tick(deltaTime);
        }
    }

    public void render(Graphics g) {
        for (GameObject object : objects) {
            object.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }
    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

}
