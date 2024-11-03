package com.bookshopping.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysDateTag extends SimpleTagSupport{
	private String format;
	private long time;
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public void setTime(long time){
		this.time=time;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Date day = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		//获取out对象
		PageContext context = (PageContext)super.getJspContext();
		JspWriter out = context.getOut();
		//输出格式化日期
		out.print(sdf.format(day));		
	}
}
