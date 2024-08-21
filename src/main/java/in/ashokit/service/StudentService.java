package in.ashokit.service;

import java.util.List;

import in.ashokit.entity.Student;

public interface StudentService {
	public boolean saveStudent(Student s);
	public List<Student> getAllStudents();
	public void delete(Integer sid);
}
