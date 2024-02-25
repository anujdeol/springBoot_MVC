package com.anuj.asn.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anuj.asn.models.Program;
import com.anuj.asn.models.Student;
import com.anuj.asn.repos.ProgramRepo;
import com.anuj.asn.repos.StudentRepo;
import com.anuj.asn.services.ProgramService;
import com.anuj.asn.services.StudentService;

@Service
public class ProgramServiceImpl implements ProgramService {

	private ProgramRepo programRepo;

	@Autowired
	public ProgramServiceImpl(ProgramRepo programRepo) {
		super();
		this.programRepo = programRepo;
	}

	@Override
	public List<Program> findPrograms() {

		System.out.println("Finding all programs...");
		return programRepo.findAll();

	}

	//

}
