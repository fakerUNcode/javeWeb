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
		// 1.�����հ�ͼƬ
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, 
				BufferedImage.TYPE_INT_RGB);
		// 2.��ȡ����
		Graphics g = image.getGraphics();
		// 3.���û�����ɫ
		g.setColor(new Color(255, 255, 255)); //��ɫ
		// 4.���ƾ��εı���
		g.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.�����Զ���ķ�������ȡ����ΪSIZE����ĸ������ϵ��ַ���
		String code = getCode(SIZE);
		HttpSession session = request.getSession();
		session.setAttribute("verifyCode", code);

		// 6.������ɫ�����壬�����ַ���
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.setFont(new Font("Consolas", Font.BOLD, FONT_SIZE));
		g.drawString(code, 12, 22); //(12,22)��������ַ��Ļ����ڴ�ͼ������������ϵͳ��λ��
		// 7.����8��������
		for (int i = 0; i < 8; i++) {
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		// 8.ѹ��ͼƬ��������ͻ���
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
