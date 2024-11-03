package filter;


import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
* @Description: Web资源缓存过滤器
*/ 
public class CacheFilter implements Filter {
	//缓存对应的Map容器<uri:缓存数据>
    private Map<String,byte[]> map = new HashMap<String,byte[]>();
    
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
    	
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        //1.获取用户请求的uri地址
        String uri = request.getRequestURI();
        
        //2.查看缓存中是否存在uri对应的数据
        byte buffer[] = map.get(uri);
        
        //3.如果缓存中有，直接将缓存的数据发送给客户端，程序返回
        if(buffer!=null){
            //根据字节数组和指定的字符编码构建字符串
            //String cacheHtmlStr = new String(buffer,response.getCharacterEncoding());
            //System.out.println("----"+cacheHtmlStr);            
            response.getOutputStream().write(buffer);
            return;
        }
        
        //4.如果没有缓存，让目标资源执行，并捕获目标资源的输出
        ResponseToBuffer myResponse = new ResponseToBuffer(response);        
        chain.doFilter(request, myResponse);
        
        //获取缓冲流中的内容的字节数组
        byte out[] = myResponse.getBuffer();
        
        //5.把资源的数据以用户请求的uri为关键字保存到缓存中
        map.put(uri, out);
        
        //6.把数据打给浏览器
        response.getOutputStream().write(out); 
    }

    public void destroy() {
    }
}

class ResponseToBuffer extends HttpServletResponseWrapper{
    private ByteArrayOutputStream bout = new ByteArrayOutputStream();  //自带缓冲区
    private PrintWriter pw;
    
    public ResponseToBuffer(HttpServletResponse response) {
        super(response);
    }
    
    public ServletOutputStream getOutputStream() throws IOException {
        return new MyServletOutputStream(bout);
    }
    
    public PrintWriter getWriter() throws IOException {
        pw = new PrintWriter(new OutputStreamWriter(bout,super.getCharacterEncoding()));
        return pw;
    }
    
    public byte[] getBuffer(){
        try{
            pw.flush();   //强制输出内存中的数据至缓冲区
            return bout.toByteArray();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
        	if(pw!=null) { pw.close();}
        	if(bout!=null) {try {bout.close();} catch(IOException e) {}}
        }
    }
}

class MyServletOutputStream extends ServletOutputStream{
	//客户端响应写入ServletOutputStream对象
    private ByteArrayOutputStream bout;
    
    public MyServletOutputStream(ByteArrayOutputStream bout){  //接收数据写到哪里
        this.bout = bout;
    }
    
    public void write(int b) throws IOException {
    	//将数据写入bout的缓冲区
        bout.write(b);
    }

    public boolean isReady() {
		return false;
	}
	public void setWriteListener(WriteListener arg0) {
	}
}