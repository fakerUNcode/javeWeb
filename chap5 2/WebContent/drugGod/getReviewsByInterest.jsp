<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.List"%>

<%
    // 获取传递的兴趣和评分参数
    String interest = request.getParameter("interest");
    String rating = request.getParameter("rating");
    List<Message> list = (List<Message>) application.getAttribute("message");

    if (list != null) {
        for (Message m : list) {
            if (m.getInterest().equals(interest)) {
                // 根据评分进行过滤
                boolean match = false;
                int score = m.getScore();

                if ("high".equals(rating) && (score == 4 || score == 5)) {
                    match = true;
                } else if ("medium".equals(rating) && score == 3) {
                    match = true;
                } else if ("low".equals(rating) && (score == 1 || score == 2)) {
                    match = true;
                } else if ("all".equals(rating)) {
                    match = true; // 如果选择"全部"，则显示所有评论
                }

                if (match) {
%>
                <div class="comment-item">
                    <div class="avatar fl">
                        <a title="用户名"><img src="image/headshot.jpg"></a>
                    </div>
                    <div class="comment">
                        <span class="comment-info">
                            <a href="#"><%= m.getUser() %></a>
                            <span><%= m.getInterest().equals("over") ? "看过" : "想看" %></span>
                            <img src="image/star<%= m.getScore() %>.png">
                            <span class="comment-time"><%= m.getDate() %></span>
                        </span>
                        <span class="comment-vote fr">
                            <span class="vote_counts"><%= m.getVote_count() %></span>
                            <input type="button" class="vote" value="有用">
                            <span style="display:none"><%= m.getId() %></span>
                        </span>
                        <p><%= m.getComment() %></p>
                    </div>
                    <div class="title_line"></div>
                </div>
<%
                }
            }
        }
    }
%>
