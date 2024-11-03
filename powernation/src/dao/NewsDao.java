package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	public List<News> findAll();  //获取student表中所有记录
	
}
