package tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysDateTag extends SimpleTagSupport{
	private String format;
	
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//��ȡout����
		PageContext context = (PageContext)super.getJspContext();
		JspWriter out = context.getOut();
		//�����ʽ������
		out.print(sdf.format(now));		
	}
}
