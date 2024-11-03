package com.bookshopping.util;


import java.awt.Color;



import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public final class VerifyCodeUtil {
	//初始化验证码字符，去掉了容易混淆的字符
	private static final String str = "ABCDEFGHJKLMNPQRSTUVWXY3456789";
	
	private static final int SIZE = 4;
	private static final int LINES = 4;
	private static final int WIDTH = 100;
	private static final int HEIGHT = 40;
	private static final int FONT_SIZE = 20;
	
	public static String getVerifyCode(){		
		//buffer用于存储生成的验证码
		StringBuffer buffer = new StringBuffer();
		
		Random ran = new Random();		
		for(int i=1; i<=SIZE; i++){ //生成随机数r，str.charAt(r)为验证码字符			
			int r = ran.nextInt(str.length());
			buffer.append(str.charAt(r));
		}
		return buffer.toString();
	}
	
	public static void outputImage(OutputStream out,String code) throws IOException{

		//1.关于图形的处理,验证码图像存储在image中
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT-16,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphic = image.getGraphics();
		graphic.setColor(Color.WHITE);
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		graphic.setFont(new Font(null,Font.BOLD+Font.ITALIC,FONT_SIZE));
		
		//2.绘制验证码字符
		for(int i=0;i<SIZE;i++){ 			
			graphic.setColor(getRandomColor());						
			graphic.drawString(code.charAt(i)+"", i*WIDTH/SIZE , HEIGHT/2); //验证码，坐标		
		}

		//3.绘制干扰线
		Random ran = new Random();
		for(int i=1;i<=LINES;i++){
			graphic.setColor(getRandomColor());
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), 
					ran.nextInt(WIDTH),ran.nextInt(HEIGHT));
		}
		
		//4.通过输出流以png格式返回
		ImageIO.write(image, "png", out);
	}
	
	public static Color getRandomColor(){
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256));
		return color;
	}
	
	
//	public static void main(String[] args) throws IOException{
//		String code = VerifyCodeUtil.getVerifyCode();
//		System.out.println(code);
//		OutputStream os = new FileOutputStream("e:\\1.png");
//		VerifyCodeUtil.outputImage(os, code);
//	}
}
