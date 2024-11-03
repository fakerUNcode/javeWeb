package dao;

import java.util.List;


import entity.Student;

public interface StudentDao {
	public List<Student> findAll();  //获取student表中所有记录
	
	public void save(Student stu);  //存一个Student到数据表
	
	
	public Student findById(int id); //按照id查询学生
	public int findByMobilephone(String mobilephone);
	
	public void update(int id, Student stu); //按照id更新学生数据

	public void delete(int id);  //按id删除学生
}
