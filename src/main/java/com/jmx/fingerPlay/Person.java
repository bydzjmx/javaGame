package com.jmx.fingerPlay;

import lombok.Data;

import java.util.Scanner;

/**
 * 猜拳游戏--玩家类
 */
@Data
public class Person {
    //玩家姓名
    private String name;
    //分数
    private int score;

    /**
     * 出拳方法
     */
    public int play(){
        //接收用户输入
        Scanner scanner = new Scanner(System.in);
        //用户输入为1,2,3
        int i = scanner.nextInt();
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
