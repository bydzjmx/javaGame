package com.jmx.PlaneGame;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

/**
 * 我的游戏窗体
 * 实现步骤：1. 继承JFrame画出页面
 * 2. 导入图片
 * 3. 添加线程进行画面的重画
 * 4. 添加坐标变量实现飞机的移动
 * 5. 定义键盘监听内部类，实现键盘移动效果
 * 6. 实现炮弹及炮弹移动
 * 7. 实现爆炸效果
 * 8. 实现计分板效果
 */

public class GameFrame extends Frame {

    //加入飞机和背景图片
    Image planeImg = GameUtil.getImage("images/plane.png");
    Image bgImg = GameUtil.getImage("images/background.jpg");
    Plane plane = new Plane(planeImg, 250, 250,planeImg.getWidth(null),planeImg.getHeight(null));
    Shell[] shells = new Shell[50];
    Explode explode;
    Date startTime = new Date();
    Date endTime;

    private Image offScreenImage = null;

    public void update(Graphics g) {
        if (offScreenImage == null)
            offScreenImage = this.createImage(500, 500);//这是游戏窗口的宽度和高度

        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    //paint,画出整个窗口及内部内容,系统自动调用
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bgImg,0,0,null);
        plane.drawMySelf(g);

        //画出50个炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i].drawMySelf(g);

            boolean intersects = shells[i].getRect().intersects(plane.getRect());
            if(intersects){
                //碰撞了,画面不显示飞机
                if(explode == null){
                    plane.live = false;
                    endTime = new Date();
                    explode = new Explode(plane.x,plane.y);
                    explode.draw(g);
                }

            }
        }

        //进行结束判断
        if(!plane.live){
            if(endTime==null){
                endTime = new Date();
            }
            int period =(int)(endTime.getTime() - startTime.getTime())/1000;
            //在窗口上打印信息
            Color color = g.getColor();
            g.setFont(new Font("宋体",Font.BOLD,50));
            g.setColor(Color.RED);
            g.drawString("游戏时间："+20+"秒",80,280);
            g.setColor(color);
        }
    }

    /**
     * 绘制图形
     */
    public void launchFrame(){
        //窗口默认不可见,设置为可见
        this.setVisible(true);
        //设置标题
        this.setTitle("飞机大作战--bydzjmx");
        //设置初始位置
        this.setLocation(300,300);
        //设置窗口大小
        this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //初始化50个炮弹
        for (int i = 0; i < shells.length; i++) {
            shells[i] = new Shell();
        }

        //运行重画线程
        new PaintThread().start();
        //监听键盘
        this.addKeyListener(new KeyMonitor());
    }

    //开启新线程反复重画窗口
    class PaintThread extends Thread{
        @Override
        public void run() {
            while(true){
                //重新绘制
                repaint();
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //定义键盘监听的内部类
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minusDirection(e);
        }
    }

    //启动方法
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.launchFrame();
    }
}
























