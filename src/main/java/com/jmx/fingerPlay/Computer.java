package com.jmx.fingerPlay;

import lombok.Data;

/**
 * 猜拳游戏--电脑类
 * 使用面向对象思想设计,分为电脑类,玩家类,游戏类
 */
@Data
public class Computer {
    //玩家姓名
    private String name;
    //分数
    private int score;

    /**
     * 出拳方法
     */
    public int play(){
        //随机出拳
        int i = (int) (Math.random()*3+1);
        switch (i){
            case 1:
                System.out.println(name+"出拳为: 剪刀");
                break;
            case 2:
                System.out.println(name+"出拳为: 石头");
                break;
            case 3:
                System.out.println(name+"出拳为: 布");
                break;
        }
        return i;
    }
}
