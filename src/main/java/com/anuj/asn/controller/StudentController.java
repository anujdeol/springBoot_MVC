package com.anuj.asn.controller;

import java.util.Objects;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anuj.asn.models.Student;

import com.anuj.asn.repos.StudentRepo;
import com.anuj.asn.services.StudentService;
import com.anuj.asn.services.impl.StudentServiceImpl;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class StudentController {

	private StudentServiceImpl studentService;

	@Autowired
	public StudentController(StudentServiceImpl studentService) {

		this.studentService = studentService;
	}

	// home
	@GetMapping("/")
	public String loginStudentForm() {
		return "home";
	}

//	// get all students
//	@GetMapping("/students")
//	public String liststudents(Model model) {
//		java.util.List<Student> students = studentService.findStudents();
//		model.addAttribute("students", students);
//		return "student-list";
//	}

	// get students
	@GetMapping("/student/profile")
	public String profilepage() {
		return "profile-page";
	}

	// get all students
	@GetMapping("/student/{userName}")
	public String listStudents(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model) {
		// Assuming studentService.findStudentsByUsername() method exists in your
		// service
		java.util.List<Student> student = studentService.checkUser(userName, password);
		model.addAttribute("student", student);
		if (!Objects.isNull(student)) {
			return "student-list";
		}

		model.addAttribute("message", "Login failed. Please check your credentials.");
		return "home";
	}

	@PostMapping("/student/edited")
	public String editStudent(@RequestParam int student_id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("city") String city,
			@RequestParam("address") String address, @RequestParam("postalCode") String postalCode, Student student,
			Model model) {

		int studentid = student_id;
		System.out.println("hitting edited " + student_id + firstName + lastName + address + postalCode);
	
		Student student1 = new Student(firstName, lastName, address, city, postalCode, student_id);

		studentService.updateStudentByStudentId1(studentid, student1);

		return "edited-page-message";
	}

//login 
	@GetMapping("/students/login")
	public String loginStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-login-form";
	}

	@PostMapping("/students/login")
	public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password,
			Model model) {

		System.out.println("hitting login route");
		java.util.List<Student> student = studentService.checkUser(userName, password);

		System.out.println("user details" + student);
		if (!Objects.isNull(student)) {

			return "redirect:/students/program";
		}

		model.addAttribute("message", "Login failed. Please check your credentials.");
		return "login-failed";
	}

//register
	@GetMapping("/students/register")
	public String registerStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-register-form";
	}

	@PostMapping("/students/register")
	public String saveRegisterStudentForm(@Validated @ModelAttribute("student") Student student,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {

			return "validation-error";
		}

		studentService.register(student);

		return "redirect:/students/login";
	}

}
