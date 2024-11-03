package entity;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable{
	private Integer id;   //NULL
	private String title; //新闻标题
	private String content; //新闻内容
	private Date date;  //新闻日期
	private boolean isReleased; //是否发布
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isReleased() {
		return isReleased;
	}
	public void setReleased(boolean isReleased) {
		this.isReleased = isReleased;
	}
	public News() {
	}
	public News(Integer id, String title, String content, Date date, boolean isReleased) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.isReleased = isReleased;
	}
}
