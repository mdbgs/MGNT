package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Student;
import ModelPackage.Teacher;

public class TeacherBean {
	List<Teacher> teacherList = new ArrayList<>();

	

	public List<Teacher> getTeacherList() {
		return teacherList;
	}
	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}
	public TeacherBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void AddTeacher(Teacher teacher){
		this.teacherList.add(teacher);
	}
	
}
