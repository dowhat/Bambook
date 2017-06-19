package com.bambook.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
 
import javax.imageio.ImageIO;

import com.jfinal.kit.PathKit;

/** 
* @author 作者 :		xueyu 
* @date 创建时间:		2017年6月18日 下午4:48:15
* @version 版本:		1.0				 
* @description:		generate verify picture
*/
public class VerifyPicture {
    public static Random random = new Random();
    public static int r(int min,int max){
        int num=0;
        num=random.nextInt(max-min)+min;
        return num;
    }
    public static String drawPicture() throws IOException {
        // TODO Auto-generated method stub
        //create a picture
        int w=120;
        int h=50;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        //draw a rectangle in the picture
        Graphics g = img.getGraphics();
        g.setColor(new Color(r(50,250),r(50,250),r(50,250)));
        g.fillRect(0, 0, w, h);
         
        String str = "aqzxswedcfrvgtbhyujklp23456789";
		String temp = "";
        for(int i=0;i<4;i++){
            g.setColor(new Color(r(50,180),r(50,180),r(50,180)));
            g.setFont(new Font("黑体",Font.PLAIN,40));
            char c = str.charAt(r(0,str.length()));
			temp += c;
            g.drawString(String.valueOf(c), 10+i*30, r(h-30,h));
        }
         
        //draw random line
        for(int i=0;i<25;i++){
            g.setColor(new Color(r(50,180),r(50,180),r(50,180)));
            g.drawLine(r(0,w), r(0,h),r(0,w), r(0,h));
        }
        //file out the picture
        File file =new File(PathKit.getWebRootPath() + "/picture/vcode.png");
        ImageIO.write(img, "png", file);
        System.out.println("图片输出完成");
		return temp;
         
    }
 
}