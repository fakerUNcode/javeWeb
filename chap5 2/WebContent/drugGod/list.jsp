<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.Date,java.util.List,java.util.ArrayList"%>
<%@ page import="java.text.DecimalFormat,java.text.SimpleDateFormat"%>
<%@ page import="forum.ComparatorHotBest"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>评论列表</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">   
    <script src="js/jquery-1.10.1.min.js"></script>
    <script type="text/javascript" src="js/vote.js"></script>
</head>
<body>
    <%
    // 验证用户是否登录
    String user = (String) session.getAttribute("username");
    if (user == null) {
        response.sendRedirect("/chap5/example/ex55/login.html");
        return;
    }

    List<Message> list = (List<Message>) application.getAttribute("message");
    if (list == null) {
        list = new ArrayList<>();
    }

    // 获取当前选择的兴趣分类: 默认为 "over" (看过)
    String selectedInterest = request.getParameter("interest");
    if (selectedInterest == null) {
        selectedInterest = "over";
    }

    // 获取当前选择的评分分类：默认为"全部"
    String selectedRating = request.getParameter("rating");
    if (selectedRating == null) {
        selectedRating = "all";
    }

    // 统计看过和想看数量
    int over_num = 0, wish_num = 0;
    for (Message m : list) {
        if ("over".equals(m.getInterest())) {
            over_num++;
        } else if ("wish".equals(m.getInterest())) {
            wish_num++;
        }
    }

    // 过滤评论列表
    List<Message> filteredList = new ArrayList<>();
    for (Message m : list) {
        if (m.getInterest().equals(selectedInterest)) {
            filteredList.add(m);
        }
    }

    // 统计好评率: 4星和5星是好评，3星是一般，2星和1星是差评
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

    int size = filteredList.size();  // 短评总数
    double high_per = (size == 0) ? 0 : high * 1.0 / size;
    double medium_per = (size == 0) ? 0 : medium * 1.0 / size;
    double low_per = (size == 0) ? 0 : low * 1.0 / size;

    DecimalFormat df = new DecimalFormat("#0");

    // 获取当前页码，默认为第一页
    String pageStr = request.getParameter("page");
    int currentPage = (pageStr == null) ? 1 : Integer.parseInt(pageStr);

    int reviewsPerPage = 10; // 每页显示的评论数
    int totalPages = (int) Math.ceil(filteredList.size() * 1.0 / reviewsPerPage);

    // 根据页码计算评论的起始和结束索引
    int startIndex = (currentPage - 1) * reviewsPerPage;
    int endIndex = Math.min(startIndex + reviewsPerPage, filteredList.size());

    // 获取当前页的评论
    List<Message> show = filteredList.subList(startIndex, endIndex);

    // 时间格式化
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>

    <div class="container">
        <div>
            <h1>我不是药神 短评</h1>
            <!-- 退出登录按钮 -->
            <form action="logout.jsp" method="post">
                <input type="submit" value="退出登录">
            </form>
        </div>
        <!-- 顶层分类标签: 看过/想看 -->
        <div class="Comments-hd clearfix">
            <ul class="commentTabs fl">
                <li id="overTab" <% if ("over".equals(selectedInterest)) { %>class="active"<% } %>>看过(<%= over_num %>)</li>
                <li id="wishTab" <% if ("wish".equals(selectedInterest)) { %>class="active"<% } %>>想看(<%= wish_num %>)</li>
            </ul>
            <div class="fr">
                <a class="comment_btn" href="add.html">我来写短评</a>
            </div>
            <div class="title_line"></div>
        </div>

        <!-- 二级分类: 全部/好评/一般/差评 -->
        <div class="comment-filter">
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('all')" <% if("all".equals(selectedRating)) { %> checked <% } %> >
                <span class="filter-name">全部</span>
            </label>
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('high')" <% if("high".equals(selectedRating)) { %> checked <% } %>>
                <span class="filter-name">好评</span>
                <span class="comment-percent"><%=df.format(high_per * 100) %>%</span>
            </label>
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('medium')" <% if("medium".equals(selectedRating)) { %> checked <% } %>>
                <span class="filter-name">一般</span>
                <span class="comment-percent"><%=df.format(medium_per * 100) %>%</span>
            </label>
            <label>
                <input type="radio" name="sort" onclick="fetchReviewsByRating('low')" <% if("low".equals(selectedRating)) { %> checked <% } %>>
                <span class="filter-name">差评</span>
                <span class="comment-percent"><%=df.format(low_per * 100) %>%</span>
            </label>
            <div class="title_line"></div>
        </div>

        <!-- 显示评论 -->
        <div class="mod-bd" id="reviewSection">
            <%
                for (Message m : show) {
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
                        <span class="comment-time"><%= sdf.format(m.getDate()) %></span>
                    </span>
                    <span class="comment-vote fr">
                        <span class="vote_counts"><%= m.getVote_count() %></span>
                        <input type="button" class="vote" value="有用">
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

        <!-- 分页功能 -->
        <div class="pagination">
            <a href="list.jsp?page=<%= currentPage - 1 %>&rating=<%= selectedRating %>&interest=<%= selectedInterest %>" 
               <% if (currentPage <= 1) { %> 
                   onclick="alert('没有上一页'); return false;" 
               <% } %>>上一页</a>
            
            <a href="list.jsp?page=<%= currentPage + 1 %>&rating=<%= selectedRating %>&interest=<%= selectedInterest %>" 
               <% if (currentPage >= totalPages) { %> 
                   onclick="alert('没有下一页'); return false;" 
               <% } %>>下一页</a>
        </div>

    </div>

    <!-- JavaScript for dynamic filtering -->
    <script>
    let currentInterest = '<%= selectedInterest %>';  // 保存当前的兴趣状态
    let currentRating = '<%= selectedRating %>';  // 保存当前的评分状态

    document.getElementById('overTab').addEventListener('click', function() {
        currentInterest = 'over';
        currentRating = 'all';  // 重置为全部评论
        fetchReviewsByInterest(currentInterest, currentRating);
    });

    document.getElementById('wishTab').addEventListener('click', function() {
        currentInterest = 'wish';
        currentRating = 'all';  // 重置为全部评论
        fetchReviewsByInterest(currentInterest, currentRating);
    });

    function fetchReviewsByInterest(interest, rating) {
        currentInterest = interest;  // 更新当前的兴趣状态
        fetch('getReviewsByInterest.jsp?interest=' + interest + '&rating=' + rating)
            .then(response => response.text())
            .then(data => {
                document.querySelector('#reviewSection').innerHTML = data;
            });
    }

    function fetchReviewsByRating(rating) {
        currentRating = rating;  // 更新当前的评分状态
        fetch('getReviewsByRating.jsp?rating=' + rating + '&interest=' + currentInterest)
            .then(response => response.text())
            .then(data => {
                document.querySelector('#reviewSection').innerHTML = data;
            });
    }
    </script>

</body>
</html>
