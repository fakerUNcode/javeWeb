<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*,entity.Student" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>学生信息管理</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/main.css" />       
    </head>
    <body>
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_fail">保存失败，姓名重复！</div>
            <!-- 路径：add.html(/stu),ad.do(/stu)平级，不需要路径 -->
            <% 
            	Student stu = (Student)request.getAttribute("stu");
            %>
            <form action="update.do?id=<%=stu.getId() %>" method="post" class="main_form">
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" class="width100" name="name" value="<%=stu.getName() %>"/>
                    <span class="required">*</span>
                    <div class="validate_msg_short"></div>
                </div>
                <div class="text_info clearfix"><span>性别：</span></div>
                <div class="input_info fee_type">
                    <input type="radio" name="sex" value="female" id="female"  <%=stu.getSex().equals("女")? "checked":""%> />
                    <label for="female">女</label>
                    <input type="radio" name="sex" value="male" id="male" <%=stu.getSex().equals("男")? "checked" : ""%>/>
                    <label for="male">男</label>                   
                </div>
                <div class="text_info clearfix"><span>生日：</span></div>
                <div class="input_info">
                    <input type="text" name="birthday" class="width100" value="<%=stu.getBirthday() %>" />
                    <span class="required">*</span>
                </div>
                <div class="text_info clearfix"><span>移动电话：</span></div>
                <div class="input_info">
                    <input type="text" name="mobilephone" class="width100" value="<%=stu.getMobilephone()%>"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>Email地址：</span></div>
                <div class="input_info">
                    <input type="text" name="email" class="width300" value="<%=stu.getEmail() %>"/>
                    <span class="required">*</span>
                    <div class="validate_msg_long"></div>
                </div>
                <div class="text_info clearfix"><span>备注：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="descr"></textarea>
                    <div class="validate_msg_short"></div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="submit" value="保存" class="btn_save" />
                    <input type="button" value="取消" class="btn_save" onclick="history.back();"/>
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[学生信息管理系统]</span>
        </div>
    </body>
</html>
