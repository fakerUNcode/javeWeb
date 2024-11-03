package forum;

import java.util.Date;

public class Message {
	private int id;
	private String user;
	private int score; //星级
	private String interest; //兴趣：看过/想看
	private String comment;
	private Date date;
	private int vote_count;  //有用的数量
	
	public Message(int id, String user, int score, String interest, 
			String comment, Date date, int vote_count) {
		super();
		this.id = id;
		this.user = user;
		this.score = score;
		this.interest = interest;
		this.comment = comment;
		this.date = date;
		this.vote_count = vote_count;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Message() {
		super();
	}
	public Message(String user, int vote_count, int score) {
		super();
		this.user = user;
		this.vote_count = vote_count;
		this.score=score;
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int useful_count) {
		this.vote_count = useful_count;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		return user+","+vote_count;
	}

}
