<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.Date,java.util.List,java.util.ArrayList"%>
<%@ page import="java.text.DecimalFormat,java.text.SimpleDateFormat"%>
<%@ page import="forum.ComparatorHotBest"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>�����б�</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">   
    <script src="js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="js/vote.js"></script>
</head>
<body>
    <%
    // ��֤�û��Ƿ��¼
    String user = (String) session.getAttribute("username");
    if (user == null) {
        response.sendRedirect("/chap5/example/ex55/login.html");
        return;
    }

    List<Message> list = (List<Message>) application.getAttribute("message");
    if (list == null) {
        list = new ArrayList<>();
    }

    // ��ȡ��ǰѡ�����Ȥ����: Ĭ��Ϊ "over" (����)
    String selectedInterest = request.getParameter("interest");
    if (selectedInterest == null) {
        selectedInterest = "over";
    }

    // ��ȡ��ǰѡ������ַ��ࣺĬ��Ϊ"ȫ��"
    String selectedRating = request.getParameter("rating");
    if (selectedRating == null) {
        selectedRating = "all";
    }

    // ͳ�ƿ������뿴����
    int over_num = 0, wish_num = 0;
    for (Message m : list) {
        if ("over".equals(m.getInterest())) {
            over_num++;
        } else if ("wish".equals(m.getInterest())) {
            wish_num++;
        }
    }

    // ���������б�
    List<Message> filteredList = new ArrayList<>();
    for (Message m : list) {
        if (m.getInterest().equals(selectedInterest)) {
            filteredList.add(m);
        }
    }

    // ͳ�ƺ�����: 4�Ǻ�5���Ǻ�����3����һ�㣬2�Ǻ�1���ǲ���
    int high = 0, medium = 0, low = 0;
    for (Message m : filteredList) {
        int score = m.getScore();
        if (score == 4 || score == 5) {
            high++;
        } else if (score == 3) {
            medium++;
        } else {
            low++;
        }
    }

    int size = filteredList.size();  // ��������
    double high_per = (size == 0) ? 0 : high * 1.0 / size;
    double medium_per = (size == 0) ? 0 : medium * 1.0 / size;
    double low_per = (size == 0) ? 0 : low * 1.0 / size;

    DecimalFormat df = new DecimalFormat("#0");

    // ��ȡ��ǰҳ�룬Ĭ��Ϊ��һҳ
    String pageStr = request.getParameter("page");
    int currentPage = (pageStr == null) ? 1 : Integer.parseInt(pageStr);

    int reviewsPerPage = 10; // ÿҳ��ʾ��������
    int totalPages = (int) Math.ceil(filteredList.size() * 1.0 / reviewsPerPage);

    // ����ҳ��������۵���ʼ�ͽ�������
    int startIndex = (currentPage - 1) * reviewsPerPage;
    int endIndex = Math.min(startIndex + reviewsPerPage, filteredList.size());

    // ��ȡ��ǰҳ������
    List<Message> show = filteredList.subList(startIndex, endIndex);

    // ʱ���ʽ��
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>

    <div class="container">
        <div>
            <h1>�Ҳ���ҩ�� ����</h1>
            <!-- �˳���¼��ť -->
            <form action="logout.jsp" method="post">
                <input type="submit" value="�˳���¼">
            </form>
        </div>
        <!-- ��������ǩ: ����/�뿴 -->
        <div class="Comments-hd clearfix">
            <ul class="commentTabs fl">
                <li id="overTab" <% if ("over".equals(selectedInterest)) { %>class="active"<% } %>>����(<%= over_num %>)</li>
                <li id="wishTab" <% if ("wish".equals(selectedInterest)) { %>class="active"<% } %>>�뿴(<%= wish_num %>)</li>
            </ul>
            <div class="fr">
                <a class="comment_btn" href="add.html">����д����</a>
            </div>
            <div class="title_line"></div>
        </div>

        <!-- ��������: ȫ��/����/һ��/���� -->
        <div class="comment-filter">
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('all')" <% if("all".equals(selectedRating)) { %> checked <% } %> >
                <span class="filter-name">ȫ��</span>
            </label>
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('high')" <% if("high".equals(selectedRating)) { %> checked <% } %>>
                <span class="filter-name">����</span>
                <span class="comment-percent"><%=df.format(high_per * 100) %>%</span>
            </label>
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('medium')" <% if("medium".equals(selectedRating)) { %> checked <% } %>>
                <span class="filter-name">һ��</span>
                <span class="comment-percent"><%=df.format(medium_per * 100) %>%</span>
            </label>
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('low')" <% if("low".equals(selectedRating)) { %> checked <% } %>>
                <span class="filter-name">����</span>
                <span class="comment-percent"><%=df.format(low_per * 100) %>%</span>
            </label>
            <div class="title_line"></div>
        </div>

        <!-- ��ʾ���� -->
        <div class="mod-bd" id="reviewSection">
            <%
                for (Message m : show) {
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
                        <span class="comment-time"><%= sdf.format(m.getDate()) %></span>
                    </span>
                    <span class="comment-vote fr">
                        <span class="vote_counts"><%= m.getVote_count() %></span>
                        <input type="button" class="vote" value="����">
                        <span style="display:none"><%= m.getId() %></span>
                    </span>
                    <p>
                        <span class="short">
                            <%= m.getComment() %>
                        </span>
                    </p>
                </div>
                <div class="title_line"></div>
            </div>
            <%
                }
            %>
        </div>

        <!-- ��ҳ���� -->
        <div class="pagination">
            <a href="list.jsp?page=<%= currentPage - 1 %>&rating=<%= selectedRating %>&interest=<%= selectedInterest %>" 
               <% if (currentPage <= 1) { %> 
                   onclick="alert('û����һҳ'); return false;" 
               <% } %>>��һҳ</a>
            
            <a href="list.jsp?page=<%= currentPage + 1 %>&rating=<%= selectedRating %>&interest=<%= selectedInterest %>" 
               <% if (currentPage >= totalPages) { %> 
                   onclick="alert('û����һҳ'); return false;" 
               <% } %>>��һҳ</a>
        </div>

    </div>

    <!-- JavaScript for dynamic filtering -->
    <script>
    let currentInterest = '<%= selectedInterest %>';  // ���浱ǰ����Ȥ״̬
    let currentRating = '<%= selectedRating %>';  // ���浱ǰ������״̬

    document.getElementById('overTab').addEventListener('click', function() {
        currentInterest = 'over';
        currentRating = 'all';  // ����Ϊȫ������
        fetchReviewsByInterest(currentInterest, currentRating);
    });

    document.getElementById('wishTab').addEventListener('click', function() {
        currentInterest = 'wish';
        currentRating = 'all';  // ����Ϊȫ������
        fetchReviewsByInterest(currentInterest, currentRating);
    });

    function fetchReviewsByInterest(interest, rating) {
        currentInterest = interest;  // ���µ�ǰ����Ȥ״̬
        fetch('getReviewsByInterest.jsp?interest=' + interest + '&rating=' + rating)
            .then(response => response.text())
            .then(data => {
                document.querySelector('#reviewSection').innerHTML = data;
            });
    }

    function fetchReviewsByRating(rating) {
        currentRating = rating;  // ���µ�ǰ������״̬
        fetch('getReviewsByRating.jsp?rating=' + rating + '&interest=' + currentInterest)
            .then(response => response.text())
            .then(data => {
                document.querySelector('#reviewSection').innerHTML = data;
            });
    }
    </script>

</body>
</html>
