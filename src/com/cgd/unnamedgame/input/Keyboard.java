package com.cgd.unnamedgame.input;

import com.cgd.unnamedgame.Handler;
import com.cgd.unnamedgame.debug.Debug;
import com.cgd.unnamedgame.obj.GameObject;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter {

    Handler handler;

    public Keyboard(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        handler.input(key, true);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        handler.input(key, false);
    }

}
