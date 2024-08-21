package in.ashokit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.ashokit.entity.Student;
import in.ashokit.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository repo;
	private EmailService emailService;

	public StudentServiceImpl(StudentRepository repo,EmailService emailService) {
		this.repo = repo;
		this.emailService=emailService;
	}

	@Override
	public boolean saveStudent(Student s) {
		Student savedStudent = repo.save(s);
		String subject="Student Registration";
		String body="your account created in Ashokit website";
		//String to="javed.farooq786@gmail.com";
		//emailService.sendEmail(subject, body,s.getEmail());
		emailService.sendEmail1(subject, body, s.getEmail());
		return savedStudent.getSid() != null;
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public void delete(Integer sid) {
		repo.deleteById(sid);
	}

}