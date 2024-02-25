package com.anuj.asn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.anuj.asn.models.Program;
import com.anuj.asn.models.Student;
import com.anuj.asn.services.impl.ProgramServiceImpl;

@Controller
public class ProgramController {

	private ProgramServiceImpl programService;

	@Autowired
	public ProgramController(ProgramServiceImpl programService) {
		this.programService = programService;
	}

	@GetMapping("/program")
	public String showProgramForm(Model model) {

		return "home";
	}

	@GetMapping("/students/program")
	public String listPrograms(Model model) {
		System.out.println("Hitting program GET endpoint");
		java.util.List<Program> programs = programService.findPrograms();
		model.addAttribute("programs", programs);
		return "program-register-form";
	}

	@GetMapping("students/payment")
	public String paymentpage() {

		return "payment";
	}

}
