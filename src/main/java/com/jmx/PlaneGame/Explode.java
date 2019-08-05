package com.jmx.PlaneGame;

import java.awt.*;

/**
 * 碰撞类，当发生碰撞时轮播爆炸图
 */
public class Explode {
    //爆炸的位置
    double x,y;
    static Image[] images = new Image[16];
    static {
        for (int i = 0; i < images.length; i++) {
            images[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
            images[i].getWidth(null);
        }
    }

    int count;

    public void draw(Graphics g){
        //轮播爆炸效果
        if(count<=15){
            g.drawImage(images[count],(int)x,(int)y,null);
            count++;
        }
    }

    public Explode(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
