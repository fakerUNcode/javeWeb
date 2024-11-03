package com.bookshopping.entity;
import java.util.List;

public class Category implements java.io.Serializable {
	private Integer id;   	//目录id
	private String  name;    //中文名
	private String  description;  //描述信息
	private Integer parentId;   //一级分类	
	
	private List<Category> childrenListCates;   //二级分类集合
    	
	//用于储存商品信息,由BookDao获取
	private List<Book> books;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", "
				+ "parentId=" + parentId
				+ "\n childrenListCates=" + childrenListCates + ", books=" + books + "]\n";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Category> getChildrenListCates() {
		return childrenListCates;
	}

	public void setChildrenListCates(List<Category> childrenListCates) {
		this.childrenListCates = childrenListCates;
	}

	/** 默认构造方法 */
	public Category() {
	}

	/** 少参数构造方法*/
	public Category(String name) {
		this.name = name;
	}

	/** 全参数构造方法 */
	public Category(String name,String description, Integer parentId) {
		this.name = name;
		this.description = description;
		this.parentId = parentId;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}