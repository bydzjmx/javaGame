package com.jmx.PlaneGame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 工具类,用于读取指定路径的图片
 */
public class GameUtil {
    private GameUtil() {
     
    }
    public static Image getImage(String path) {
        BufferedImage bi = null;
        try {
            //获取类加载器,加载资源的根目录,获取相对资源的位置
            URL u = GameUtil.class.getClassLoader().getResource(path);
            //读取图片信息,返回Image对象
            bi = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bi;
    }
}