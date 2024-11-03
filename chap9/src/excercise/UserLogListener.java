package excercise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class UserLogListener implements HttpSessionAttributeListener{
	FileOutputStream fos = null;
	PrintWriter pw = null;			
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		String atrname = hsbe.getName();  //事件源
		if(atrname.equals("user")){  //发生变化的是用户信息
			HttpSession session = hsbe.getSession();
			String username =(String)session.getAttribute("user");
			try {
				fos = new FileOutputStream("e:\\log.txt",true);
				pw = new PrintWriter(fos);
				pw.println((username+"登录,at "+ sdf.format(new Date())));
				pw.flush();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally{
				if(pw!=null)
					pw.close();
			}
		}
	}

	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		String atrname = hsbe.getName();
		HttpSession session = hsbe.getSession();
		if(atrname.equals("user")){
			try {
				fos = new FileOutputStream("e:\\log.txt",true);  //true: 追加模式
				pw = new PrintWriter(fos);
				String username = (String)session.getAttribute("logoutusername");
				pw.println(username+"登出,at "+ sdf.format(new Date()));
				pw.flush();
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally{
				if(pw!=null)
					pw.close();
			}
		}
		
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		
	}

}
