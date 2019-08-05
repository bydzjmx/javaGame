package com.jmx.PlaneGame;

import java.awt.*;

/**
 * 创建炮弹类
 */
public class Shell extends GameObject{

    double degree;

    public Shell(){
        x=200;
        y=200;
        width=10;
        height=10;

        speed = 3;
        //沿着随机的方向移动
        degree = Math.random()*(Math.PI*2);
    }

    @Override
    public void drawMySelf(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.ORANGE);

        //画出圆形小点
        g.fillOval((int)x,(int)y,width,height);
        //炮弹沿着任意方向飞,修改坐标x和y即可
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        //碰撞后反弹
        if(x<10 || x>Constant.GAME_WIDTH - width-10){
            degree = Math.PI - degree;
        }
        if(y<40 || y>Constant.GAME_HEIGHT - height-10){
            degree = -degree;
        }

        g.setColor(color);
    }
}
