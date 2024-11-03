package listener;

import javax.servlet.ServletContext;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CountListener implements HttpSessionListener {
    private int count = 0;  /*在线人数*/
    
    //创建session事件
    public void sessionCreated(HttpSessionEvent se) {
    	//在线人数加1
        count++;
        //从事件对象获取session
        HttpSession session = se.getSession();
        //从session获取ServletContext
        ServletContext context = session.getServletContext();
        //保存在线人数
        context.setAttribute("count", count);
    }
    //销毁session事件
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;        
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        context.setAttribute("count", count);
    }
}