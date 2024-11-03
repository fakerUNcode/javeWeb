package com.bookshopping.entity;

public class Book implements java.io.Serializable{
	private Integer id;   		//商品id
	
	private String bookName; 	//书名
	private String author;		//作者
	private String publishing;	//出版社
	private long publishTime;	//出版时间
	private String whichEdtion;	//版次
	private String totalPage;	//页数，"500页"
	private long printTime;		//印刷时间
	private String isbn;		//ISBN
	private String authorSummary;//摘要	
	private String catalogue;	 //所属目录
	private String description; //描述信息
	private double fixedPrice;	//定价
	private double realPrice;	//本网价
	private String picture;	//图片位置
	
	private String firstCate;  	//一级分类
	private String secondCate;  //二级分类	
	
	public Book() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishing() {
		return publishing;
	}
	public void setPublishing(String publishing) {
		this.publishing = publishing;
	}
	public long getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(long publishTime) {
		this.publishTime = publishTime;
	}
	public String getWhichEdtion() {
		return whichEdtion;
	}
	public void setWhichEdtion(String whichEdtion) {
		this.whichEdtion = whichEdtion;
	}
	public String getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}
	public long getPrintTime() {
		return printTime;
	}
	public void setPrintTime(long printTime) {
		this.printTime = printTime;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthorSummary() {
		return authorSummary;
	}
	public void setAuthorSummary(String authorSummary) {
		this.authorSummary = authorSummary;
	}
	public String getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getFixedPrice() {
		return fixedPrice;
	}
	public void setFixedPrice(double fixedPrice) {
		this.fixedPrice = fixedPrice;
	}
	public double getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(double realPrice) {
		this.realPrice = realPrice;
	}
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getFirstCate() {
		return firstCate;
	}
	public void setFirstCate(String firstCate) {
		this.firstCate = firstCate;
	}
	public String getSecondCate() {
		return secondCate;
	}
	public void setSecondCate(String secondCate) {
		this.secondCate = secondCate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", author=" + author + ", publishing=" + publishing
				+ ", publishTime=" + publishTime + ", whichEdtion=" + whichEdtion + ", totalPage=" + totalPage
				+ ", printTime=" + printTime + ", isbn=" + isbn + ", authorSummary=" + authorSummary + ", catalogue="
				+ catalogue + ", description=" + description + ", fixedPrice=" + fixedPrice + ", realPrice=" + realPrice
				+ ", picture=" + picture + ", firstCate=" + firstCate + ", secondCate=" + secondCate + "]";
	}

}
