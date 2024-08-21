package in.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entity.Student;
import in.ashokit.service.StudentService;

@Controller
public class StudentController {

	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	// method to display empty form
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

	// method to save student form data
	@GetMapping("/saveStudent")
	public ModelAndView handleSubmitBtn(Student s) {
		ModelAndView mav = new ModelAndView();
		boolean isSaved = service.saveStudent(s);
		if (isSaved) {
			mav.addObject("smsg", "Student Saved");
		} else {
			mav.addObject("emsg", "Failed To Save");
		}
		mav.setViewName("index");
		return mav;
	}

	// method to get all students data

	@GetMapping("/getData")
	public ModelAndView getAllStudents() {
		List<Student> stuList = service.getAllStudents();
		ModelAndView mav = new ModelAndView();
		mav.addObject("students", stuList);
		mav.setViewName("data");
		return mav;
	}

	@GetMapping("/delete")
	public ModelAndView deleteRecord(@RequestParam("sid") Integer sid) {
		service.delete(sid);
		List<Student> stuList = service.getAllStudents();
		ModelAndView mav = new ModelAndView();
		mav.addObject("students", stuList);
		mav.addObject("msg", "Deleted Successfully");
		mav.setViewName("data");
		return mav;
	}

}