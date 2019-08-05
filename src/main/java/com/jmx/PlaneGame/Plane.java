package com.jmx.PlaneGame;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * 飞机类，
 * 1.重写draw方法,控制移动
 * 2.接收键盘信号，移动指定方向
 */
public class Plane extends GameObject {
    //用于控制飞机的移动方向
    boolean left,up,right,down;
    int speed = 3;
    boolean live = true;

    public Plane(Image image,int x,int y){
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public Plane(Image image,int x, int y,int width,int height){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawMySelf(Graphics g) {
        //如果飞机存活，重新绘制飞机
        if(live){
            super.drawMySelf(g);
            //判断移动方向
            if(left){
                x-=speed;
            }
            if(right){
                x+=speed;
            }
            if(up){
                y-=speed;
            }
            if(down){
                y+=speed;
            }
        }
    }


    //增加方向
    public void addDirection(KeyEvent event){
        //获取键盘事件，判断键盘的code
        int keyCode = event.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    public void minusDirection(KeyEvent event){
        //获取键盘事件，判断键盘的code
        int keyCode = event.getKeyCode();
        switch (keyCode){
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }
}
