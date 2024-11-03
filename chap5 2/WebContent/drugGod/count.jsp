<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.List,java.util.ArrayList"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    List<Message> list = (List<Message>) application.getAttribute("message");

    // 获取当前用户已投票的评论 ID 列表
    List<Integer> votedIds = (List<Integer>) session.getAttribute("votedIds");
    if (votedIds == null) {
        votedIds = new ArrayList<>(); // 初始化投票ID列表
    }

    // 检查用户是否已经对该评论投过票
    if (votedIds.contains(id)) {
        out.print("您已经投过票了");
    } else {
        // 投票并增加票数
        for (Message m : list) {
            if (m.getId() == id) {
                m.setVote_count(m.getVote_count() + 1);
                out.print(m.getVote_count());
                break;
            }
        }
        // 将评论 ID 添加到用户的已投票列表中
        votedIds.add(id);
        session.setAttribute("votedIds", votedIds);  // 更新用户的投票记录
        application.setAttribute("message", list);  // 更新全局的评论列表
    }
%>
