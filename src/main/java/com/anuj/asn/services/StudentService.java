package com.anuj.asn.services;

import com.anuj.asn.models.Student;

import java.util.List;

public interface StudentService {

	Student register(Student student);

	List<Student> findStudents();

	List<Student> checkUser(String userName, String password);

	List<Student> findStudentsByUsername(String userName);

}
