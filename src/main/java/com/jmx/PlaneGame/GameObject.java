package com.jmx.PlaneGame;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

/**
 * 窗体中的所有对象的父类，其有共同的特点
 * 1.图片对象
 * 2.坐标位置
 * 3.移动速度
 * 4.宽度和高度
 */
@Data
@NoArgsConstructor
public class GameObject {
     Image image;
     double x,y;
     int speed;
     int width,height;

    /**
     * 绘制方法
     */
    public void drawMySelf(Graphics g){
        g.drawImage(image, (int)x, (int)y, null);
        //根据方向进行判断移动的方向
    }

    public GameObject(Image image, double x, double y, int speed, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    /**
     * 返回对象的矩形对象，便于后续碰撞检测使用
     * @return
     */
    public Rectangle getRect(){
        return new Rectangle((int)x,(int)y,width,height);
    }
}
