<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.List,java.util.ArrayList"%>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    List<Message> list = (List<Message>) application.getAttribute("message");

    // ��ȡ��ǰ�û���ͶƱ������ ID �б�
    List<Integer> votedIds = (List<Integer>) session.getAttribute("votedIds");
    if (votedIds == null) {
        votedIds = new ArrayList<>(); // ��ʼ��ͶƱID�б�
    }

    // ����û��Ƿ��Ѿ��Ը�����Ͷ��Ʊ
    if (votedIds.contains(id)) {
        out.print("���Ѿ�Ͷ��Ʊ��");
    } else {
        // ͶƱ������Ʊ��
        for (Message m : list) {
            if (m.getId() == id) {
                m.setVote_count(m.getVote_count() + 1);
                out.print(m.getVote_count());
                break;
            }
        }
        // ������ ID ��ӵ��û�����ͶƱ�б���
        votedIds.add(id);
        session.setAttribute("votedIds", votedIds);  // �����û���ͶƱ��¼
        application.setAttribute("message", list);  // ����ȫ�ֵ������б�
    }
%>
