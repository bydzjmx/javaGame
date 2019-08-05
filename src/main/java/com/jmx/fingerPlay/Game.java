package com.jmx.fingerPlay;

import java.util.Scanner;

/**
 * 猜拳游戏---游戏类
 */
public class Game {
    //电脑玩家
    private Computer computer;
    //用户玩家
    private Person person;
    //游戏进行的局数
    private int count;
    //记录输入
    private Scanner in;

    /**
     * 初始化方法
     */
    public void init(){
        computer = new Computer();
        person = new Person();
        count = 0;
        in = new Scanner(System.in);
        selectPerson();
        selectComputer();
    }

    //给玩家选择角色
    private void selectPerson() {
        System.out.println("请选择你的角色：1.亚瑟    2.后羿    3.关羽");
        int roleP = in.nextInt();
        switch (roleP){
            case 1:
                person.setName("亚瑟");
                System.out.println("你选择的角色是: 亚瑟");
                break;
            case 2:
                person.setName("后羿");
                System.out.println("你选择的角色是: 后羿");
                break;
            case 3:
                person.setName("关羽");
                System.out.println("你选择的角色是: 关羽");
                break;
        }
    }

    //给电脑选择角色
    private void selectComputer() {
        System.out.println("请给电脑选择角色：1.孙悟空    2.猪八戒    3.沙和尚");
        int roleC = in.nextInt();
        switch (roleC) {
            case 1:
                computer.setName("孙悟空");
                System.out.println("computer选择的角色为：孙悟空");
                break;
            case 2:
                computer.setName("猪八戒");
                System.out.println("computer选择的角色为：猪八戒");
                break;
            case 3:
                computer.setName("沙和尚");
                System.out.println("computer选择的角色为：沙和尚");
                break;
        }
    }

    //开始游戏
    public void play(){
        //标志位
        boolean flag = true;
        while(flag){
            System.out.println("请"+person.getName()+"出拳, 1为剪刀, 2为石头, 3为布");
            int playP = person.play();
            int playC = computer.play();
            if(playP !=1 && playP !=2 && playP !=3){
                System.out.println("请输入正确的拳法");
            }
            if((playP==1 && playC==3)||((playP==2 && playC==1)) || (playP==3 && playC==2)){
                System.out.println(person.getName()+"赢了");
                person.setScore(person.getScore()+10);
                computer.setScore(computer.getScore()-10);
            }else if(playP == playC){
                System.out.println("平局");
            }else {
                System.out.println(computer.getName()+"赢了");
                computer.setScore(computer.getScore()+10);
                person.setScore(person.getScore()-10);
            }
            count++;
            System.out.println("是否进行下一局游戏?(Y/N)");
            String answer = in.next();
            if("N".equals(answer) || "n".equals(answer)){
                flag = false;
            }
        }
    }

    //结果
    public void result(){
        System.out.println("--------------------------------------------------------");
        System.out.println(person.getName()+"共获得了："+person.getScore()+"分");
        System.out.println(computer.getName()+"共获得了："+computer.getScore()+"分");
        System.out.println("一共进行了："+count+"局游戏");
        if(person.getScore() > computer.getScore())
            System.out.println(person.getName()+"赢了");
        else if(person.getScore() == computer.getScore())
            System.out.println("最终为平局");
        else
            System.out.println(computer.getName()+"赢了");
    }
}
