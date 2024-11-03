package filter;

import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class SensitiveWordsFilter implements Filter {
	// 定义不同级别的敏感词的集合
	private List<String> stopWords = new ArrayList<String>();
	private List<String> replaceWords = new ArrayList<String>();

	public void init(FilterConfig filterConfig) throws ServletException {
		try {
			// 在初始化方法中导入词库
			InputStream in = SensitiveWordsFilter.class.getClassLoader().
					getResourceAsStream("words.txt");			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			// 逐行读取文件
			String line;			
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");  
				if (parts != null && parts.length == 2){
					if (parts[1].equals("1")) {  //禁用词库
						stopWords.add(parts[0]);
					} else if (parts[1].equals("2")) {  //替换词库
						replaceWords.add(parts[0]);
					} 
				}
			}
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain)	throws IOException, ServletException {

		String data = ((HttpServletRequest) req).getParameter("data");
		if(data!=null){
			// 检查评论是否包含禁用词
			for (String word : stopWords) {
				// 将查询目标编译为正则表达式，返回表达式对象
				Pattern pattern = Pattern.compile(word);
				// 用正则对象去匹配提交的数据
				Matcher matcher = pattern.matcher(data);
				// 通过匹配器的find()方法查找
				if (matcher.find()) {
					req.setAttribute("message", "评论中包含非法词汇，禁止发表！");
					req.getRequestDispatcher("/forbidden.jsp").forward(req, res);
					return;
				}
			}
		}
		// 使用包装类处理替换词，重写getParameter()方法
		WordsRequest wordrequest = 
				new WordsRequest((HttpServletRequest) req,replaceWords);
		
		chain.doFilter(wordrequest, res);
	}
	
	public void destroy() {
	}
}

class WordsRequest extends HttpServletRequestWrapper {
	private List<String> replaceWords;
	
	public WordsRequest(HttpServletRequest request,List<String> replaceWords) {
		super(request);
		this.replaceWords=replaceWords;
	}

	public String getParameter(String name) {
		String value = super.getParameter(name);
		for (String word : replaceWords) {
			// 替换value中所有需要替换的词
			value = value.replaceAll(word, "***");
		}
		return value;
	}
}
