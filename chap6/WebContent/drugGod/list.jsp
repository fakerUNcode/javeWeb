<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="GBK"%>
<%@ page import="forum.Message,java.util.Date,java.util.List"%>
<%@ page import="java.text.DecimalFormat,java.text.SimpleDateFormat"%>
<%@ page import="forum.ComparatorHotBest"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">	
	<script src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="js/vote.js" ></script>
	<style type="text/css">
		
	</style>
<body>
	<jsp:useBean id="bar" class="forum.MessageBean" scope="application" />
	<%
		List<Message> list = bar.getList();
	
		//1ͳ�ƺ�����,4�Ǻ�5���Ǻ�����3����һ�㣬2�Ǻ�1���ǲ���
		int high=0,medium=0,low=0;
		//2ͳ�ƿ������뿴����
		int wish_num=0,over_num=0;
		for(Message m:list){
			int score = m.getScore();
			if(score==4 || score==5){
				high++;
			}else if(score==3){
				medium++;
			}else{
				low++;
			}
			String interest = m.getInterest();
			if(interest.equals("wish")){
				wish_num++;
			}else{
				over_num++;
			}
		}
		int size = list.size();  //��������
		double high_per = high*1.0/size;
		double medium_per = medium*1.0/size;
		double low_per = low*1.0/size;
		
		DecimalFormat df = new DecimalFormat("#0");
		
		//3.��ǰ��ǩΪ"����",����������ɸѡ��10����ʾ
		list.sort(new ComparatorHotBest());
		List<Message> show = null;
		if(size>=10){
			show = list.subList(0, 11);
		}else{
			show = list.subList(0, size);
		}
		
		//4.ʱ���ʽ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
	%>
	<div class="container">
		<div>
			<h1>�Ҳ���ҩ�� ����</h1>
		</div>
		<div class="Comments-hd clearfix">
			<ul class="commentTabs fl">
				<li class="active">����(<%=over_num %>)</li>
				<li><a href="#">�뿴(<%=wish_num %>)</a></li>
			</ul>
			<div class="fr">
				<a class="comment_btn " href="add.html">����д����</a>
			</div>
			<div class="title_line"></div>
		</div>
		<div class="comments-sortby">
			<span>����</span>
			<a href="#">����</a>
			<a href="#">����</a>
			<div class="title_line"></div>
		</div>
		
		<div class="comment-filter">
			<label for="">
				<input type="radio" name="sort" >
				<span class="filter-name">ȫ��</span>
			</label>
			<label for="">
				<input type="radio" name="sort" checked="checked">
				<span class="filter-name">����</span>
				<span class="comment-percent"><%=df.format(high_per*100) %>%</span>
			</label>
			<label for="">
				<input type="radio" name="sort" >
				<span class="filter-name">һ��</span>
				<span class="comment-percent"><%=df.format(medium_per*100) %>%</span>
			</label>
			<label for="">
				<input type="radio" name="sort" >
				<span calss="filter-name">����</span>
				<span class="comment-percent"><%=df.format(low_per*100) %>%</span>
			</label>
			<div class="title_line"></div>
		</div>

		<div class="mod-bd ">
			<%
				for(Message m: show){
			%>
			<div class="comment-item">
				<div class="avatar fl">
					<a title="�û���"><img src="image/headshot.jpg"></a>
				</div>
				<div class="comment">
					<span class="comment-info">
						<a href="#"><%=m.getUser() %></a>
						<%
							if(m.getInterest().equals("over")){
						%>
						<span>����</span>
						<%}else{
						%>
						<span>�뿴</span>
						<%} %>
						<img src="image/star<%=m.getScore() %>.png">
						<span class="comment-time"> <%=sdf.format(m.getDate()) %></span>
					</span>
					<span class="comment-vote fr">
						<span class="vote_counts"><%=m.getVote_count() %></span>
						<input type="button" class="vote" value="����">
						<span style="display:none"><%=m.getId() %></span>
					</span>
					<p>
						<span class="short">
							<%=m.getComment() %>
						</span>
					</p>
				</div>
				<div class="title_line"></div>
			</div>
			<%
				}
			%>
		</div>

	</div>
</body>
</html>
