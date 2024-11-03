<%@ page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.List,entity.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>学生信息管理系统</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/main.css" />        
    </head>
    <body>
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">                                      
                    <input type="button" value="增加" class="btn_add" onclick="location.href='add.html';" />
                </div> 
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>学生ID</th>
                            <th class="width100">姓名</th>
                            <th>性别</th>
                            <th>生日</th>
                            <th>手机号</th>
                            <th>Email</th>
                            <th class="width200">备注</th>
                        </tr>  
						<c:forEach items="${student}" var="s">      
	                        <tr>
	                            <td>${s.id}</td>
	                            <td>${s.name }</a></td>
	                            <td>${s.sex} </td>
	                            <td>${s.birthday}</td>
	                            <td>${s.mobilephone}</td>	                           
	                            <td>${s.email }</td>                 
	                            <td>                                
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdate.do?id=${s.id}';" />
	                                <input type="button" value="删除" class="btn_delete" onclick="location.href='delete.do?id=${s.id}';" />
	                            </td>
	                        </tr>
	                    </c:forEach>                    
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
