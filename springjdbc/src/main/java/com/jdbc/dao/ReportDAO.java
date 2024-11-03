package com.jdbc.dao;

import java.util.List;
import com.jdbc.bean.Report;

public interface ReportDAO {	
	void delete(int id);
	void update(Report report);
	void save(Report report);
	Report findById(int id);    
    List<Report> findAll();
    List<Report> find(int begin, int end);
}
