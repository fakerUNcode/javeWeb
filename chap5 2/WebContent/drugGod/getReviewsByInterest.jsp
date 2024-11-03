<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.List"%>

<%
    // ��ȡ���ݵ���Ȥ�����ֲ���
    String interest = request.getParameter("interest");
    String rating = request.getParameter("rating");
    List<Message> list = (List<Message>) application.getAttribute("message");

    if (list != null) {
        for (Message m : list) {
            if (m.getInterest().equals(interest)) {
                // �������ֽ��й���
                boolean match = false;
                int score = m.getScore();

                if ("high".equals(rating) && (score == 4 || score == 5)) {
                    match = true;
                } else if ("medium".equals(rating) && score == 3) {
                    match = true;
                } else if ("low".equals(rating) && (score == 1 || score == 2)) {
                    match = true;
                } else if ("all".equals(rating)) {
                    match = true; // ���ѡ��"ȫ��"������ʾ��������
                }

                if (match) {
%>
                <div class="comment-item">
                    <div class="avatar fl">
                        <a title="�û���"><img src="image/headshot.jpg"></a>
                    </div>
                    <div class="comment">
                        <span class="comment-info">
                            <a href="#"><%= m.getUser() %></a>
                            <span><%= m.getInterest().equals("over") ? "����" : "�뿴" %></span>
                            <img src="image/star<%= m.getScore() %>.png">
                            <span class="comment-time"><%= m.getDate() %></span>
                        </span>
                        <span class="comment-vote fr">
                            <span class="vote_counts"><%= m.getVote_count() %></span>
                            <input type="button" class="vote" value="����">
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
