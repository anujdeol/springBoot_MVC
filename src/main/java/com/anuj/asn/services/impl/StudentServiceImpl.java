package com.anuj.asn.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.asn.models.Student;
import com.anuj.asn.repos.StudentRepo;
import com.anuj.asn.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepo studentRepo;

	@Autowired
	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public Student register(Student student) {
		System.out.println("hitting register");

		return studentRepo.save(student);

	}

	@Override
	public List<Student> checkUser(String userName, String password) {
		System.out.println("qwertyiuytrewqqwertyuytrewq");

		List<Student> stud = studentRepo.findByUserNameAndPassword(userName, password);

		if (!stud.isEmpty()) {
			System.out.println("User found: " + stud);
			return stud;
		} else {
			System.out.println("User not found or invalid credentials");
			return null;
		}
	}

	public List<Student> findStudents() {
		List<Student> stud = studentRepo.findAll();

		if (!stud.isEmpty()) {
			System.out.println("User found: " + stud);
			return stud;
		} else {
			System.out.println("User not found or invalid credentials");
			return null;
		}
	}

	public List<Student> findStudentsByUsername(String userName) {
		System.out.println("list students");

		List<Student> stud = studentRepo.findByUserName(userName);

		if (!stud.isEmpty()) {
			System.out.println("User found: " + stud);
			return stud;
		} else {
			System.out.println("User not found or invalid credentials");
			return null;
		}

	}

	public List<Student> updateStudentByStudentId1(int i, Student student) {

		System.out.println("ID in impl" + student + student.getFirstname());

		java.util.List<Student> stud = studentRepo.updateStudentByStudentId(i, student);
		return stud;

	}

}
