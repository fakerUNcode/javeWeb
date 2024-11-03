<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%
		out.print("<h3>缓冲区初始："+out.getBufferSize()+"字节</h3>");
		out.print("<h4>《钱塘湖春行》【唐】白居易</h4>");
		out.print("<h4>孤山寺北贾亭西，水面初平云脚低。</h4>");
		out.print("<h4>几处早莺争暖树，谁家新燕啄春泥。</h4>");
		out.print("<h3>缓冲区剩余："+out.getRemaining()+"字节</h3>");
		out.flush();
		out.print("<h3>缓冲区刷新后："+out.getRemaining()+"字节</h3>");		
		out.print("<h4>乱花渐欲迷人眼，浅草才能没马蹄。</h4>");
		out.print("<h4>最爱湖东行不足，绿杨阴里白沙堤。</h4>");
	%>
</html>
