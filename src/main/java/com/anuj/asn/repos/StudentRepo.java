package com.anuj.asn.repos;

import com.anuj.asn.models.*;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findByUserName(String userName);

	List<Student> findByUserNameAndPassword(String userName, String password);

	Optional<Student> findByStudentId(int studentId);

	default List<Student> updateStudentByStudentId(int studentId, Student updatedStudent) {
		System.out.println("name to be updated" + studentId);

		findByStudentId(studentId).ifPresent(student -> {
			System.out.println("setting values in student object");
			student.setFirstname(updatedStudent.getFirstname());
			student.setLastname(updatedStudent.getLastname());
			student.setCity(updatedStudent.getCity());
			student.setAddress(updatedStudent.getAddress());
			student.setPostal_code(updatedStudent.getPostal_code());
			save(student); // Save the updated student
		});

		return null;
	}
}
