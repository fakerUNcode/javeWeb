<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List,entity.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>学生信息管理系统</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/main.css" />   
        <script src="jquery-1.10.1.min.js"></script>
        <script src="search.js"></script>     
    </head>
    <body>
       
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
              	<!--查询-->
                <div class="search_add">                        
                    <div>学生ID：<input type="text"  id="id" value="" class="width70 text_search" /></div>
                    <div>姓名：<input type="text" id="name" value="" class="width100 text_search" /></div>                            
                    <div>手机号：<input type="text" id="mobilephone" value="" class="width100 text_search" /></div>
                    <div>
                    	<span>性别</span>
                        <select class="select_search" id="select_search" id="sex">
                        	  <option value="all">全选</option>
                        	  <option value="male">男</option>
                        	  <option value="female">女</option>
                        </select>
                    </div>
                    <div>
                    	<input type="button" value="搜索" class="btn_add" id="search"/>
                    	<input type="button" value="删除" class="btn_add" />                  
                    	<input type="button" value="增加" class="btn_add" onclick="location.href='add.html';" />
                    </div>
                </div>  
               
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                        	<th>
                        		</div><input type="checkbox"></input>全选</th>
                            <th>学生ID</th>
                            <th class="width100">姓名</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>手机号</th>
                            <th>Email</th>
                            <th class="width200">备注</th>
                        </tr>                               
                        <%
                            List<Student> stu = (List)request.getAttribute("student");
                            for(Student s:stu){
                        %>       
	                        <tr>
	                        	<td><input type="checkbox" name="select"></input></td>
	                            <td><%=s.getId() %></td>
	                            <td><%=s.getName() %></a></td>
	                            <td><%=s.getSex() %> </td>
	                            <td><%=s.getBirthday() %></td>
	                            <td><%=s.getMobilephone() %></td>	                           
	                            <td><%=s.getEmail() %></td>                 
	                            <td>                                
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdate.do?id=<%=s.getId()%>';" />
	                                <input type="button" value="删除" class="btn_delete" onclick="location.href='delete.do?id=<%=s.getId()%>';" />
	                            </td>
	                        </tr>
	                     <%
	                       	}
	                     %>                       
                    </table>                   
                </div>
                <!--分页-->
                <div id="pages">
                <%
                	int currentPage = (int)request.getAttribute("currentPage");
                	System.out.println("currentPage："+currentPage);
                	int totalPage = (int)request.getAttribute("totalPage");
                	System.out.println("totalPage："+totalPage);
                	if(currentPage>1){
                %>
        	        <a href="find.do?page=<%=currentPage-1%>" >上一页</a>
        	    <%
        	    	}else{
        	    %>
        	    	<a href="#" >上一页</a>
        	    <%
        	    	}
                	for(int i=1; i<=totalPage; i++){
                		if(currentPage==i){
        	    %>
                    <a href="findAll.do?page=<%=i%>" class="current_page"><%=i %></a>
                 <%
                	}else{                		
                %>
                	<a href="findAll.do?page=<%=i%>"><%=i %></a>
                <%	
                	}
                	} //for
                	if(currentPage<totalPage){
                 %>
                    <a href="findAll.do?page=<%=currentPage+1%>">下一页</a>
                 <%
        	    	}else{
        	     %>
                 	<a href="#">下一页</a>
                 <%
                 	}
                 %>
                </div>
                <input type="hidden" id="totalPage" value="<%=totalPage %>"/>
            </form>
        </div>
        <!--主要区域结束-->
       <div id="footer">
            <span>[学生信息管理系统]</span>
        </div>
    </body>
</html>
