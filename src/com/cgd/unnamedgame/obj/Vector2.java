package com.cgd.unnamedgame.obj;

public class Vector2 {
    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {}

    public void Double()
    {
        this.x *= 2;
        this.y *= 2;
    }

    public static final Vector2 zero = new Vector2(0, 0);
    public static final Vector2 one = new Vector2(1, 1);
    public static final Vector2 down = new Vector2(0, -1);
    public static final Vector2 up = new Vector2(0, 1);
    public static final Vector2 left = new Vector2(-1, 0);
    public static final Vector2 right = new Vector2(1, 0);
}
