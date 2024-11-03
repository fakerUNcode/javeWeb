package dao;

import java.util.List;


import entity.Student;

public interface StudentDao {
	public List<Student> findAll();  //��ȡstudent�������м�¼
	
	public void save(Student stu);  //��һ��Student�����ݱ�
	
	
	public Student findById(int id); //����id��ѯѧ��
	public int findByMobilephone(String mobilephone);
	
	public void update(int id, Student stu); //����id����ѧ������

	public void delete(int id);  //��idɾ��ѧ��
}
