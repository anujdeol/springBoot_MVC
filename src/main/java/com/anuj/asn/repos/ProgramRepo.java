package com.anuj.asn.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anuj.asn.models.Program;

public interface ProgramRepo extends JpaRepository<Program, String> {

}
