package com.anuj.asn.repos;
import com.anuj.asn.models.Enrollment;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {

}
