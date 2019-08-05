package com.jmx.fingerPlay;

/**
 * 猜拳游戏--测试类
 */
public class Test {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        game.play();
        game.result();
    }
}
