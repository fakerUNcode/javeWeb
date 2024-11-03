<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List,entity.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>学生信息管理系统</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/main.css" />        
    </head>
    <body>
       
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
              	<!--查询-->
                <div class="search_add">                        
                    <div>学生ID：<input type="text"  value="" class="width70 text_search" /></div>
                    <div>姓名：<input type="text" value="" class="width100 text_search" /></div>                            
                    <div>手机号：<input type="text" value="" class="width100 text_search" /></div>
                    <div>
                    	<span>性别</span>
                        <select class="select_search" id="select_search">
                        	  <option value="all">全选</option>
                        	  <option value="male">男</option>
                        	 <option value="female">女</option>
                        </select>
                    </div>
                    <div>
                    	<input type="button" value="搜索" class="btn_add" />
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
 									<input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdate.do?id=<%=s.getId() %>'" />
	                                <input type="button" value="删除" class="btn_delete" onclick="location.href='delete.do?id=<%=s.getId() %>'" />
	                            </td>
	                        </tr>
	                     <%
	                       	}
	                     %>                       
                    </table>                   
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
       <div id="footer">
            <span>[学生信息管理系统]</span>
        </div>
    </body>
</html>
