package verify;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class CreateVerifyCodeServlet extends HttpServlet {
	private static final int SIZE = 5;
	private static final int WIDTH = 80;
	private static final int HEIGHT = 30;
	private static final int FONT_SIZE = 20;

	public void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 1.创建空白图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, 
				BufferedImage.TYPE_INT_RGB);
		// 2.获取画笔
		Graphics g = image.getGraphics();
		// 3.设置画笔颜色
		g.setColor(new Color(255, 255, 255)); //白色
		// 4.绘制矩形的背景
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.调用自定义的方法，获取长度为SIZE的字母数字组合的字符串
		String code = getCode(SIZE);
		HttpSession session = request.getSession();
		session.setAttribute("verifyCode", code);

		// 6.设置颜色、字体，绘制字符串
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.setFont(new Font("Consolas", Font.BOLD, FONT_SIZE));
		g.drawString(code, 12, 22); //(12,22)是最左侧字符的基线在此图形上下文坐标系统的位置
		// 7.绘制8条干扰线
		for (int i = 0; i < 8; i++) {
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		// 8.压缩图片并输出到客户端
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		ImageIO.write(image, "jpeg", os);
		os.close();
	}

	String getCode(int size) {
		String str = "ABCDEFGHJKLMNPQRSTUVWXY3456789";
		StringBuffer code = new StringBuffer();
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			int pos = r.nextInt(str.length());
			code.append(str.charAt(pos));
		}
		return code.toString();
	}

}
