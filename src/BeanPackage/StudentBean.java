package BeanPackage;

import java.util.ArrayList;
import java.util.List;

import ModelPackage.Student;

public class StudentBean {
	List<Student> studentList = new ArrayList<>();

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public StudentBean() {
	}
	public void AddStudent(Student student){
		this.studentList.add(student);
	}
}
