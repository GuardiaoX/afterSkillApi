package br.com.afterSkillApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.afterSkillApi.domains.Skill;
import br.com.afterSkillApi.services.SkillService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "Bearer Auth")
@RequestMapping("/skill")
public class Skillcontroller {

	@Autowired
	SkillService skillService;

	@GetMapping("/all")
	public List<Skill> getAll() {
		return skillService.getAll();
	}

	@GetMapping("/")
	public Skill getById(@RequestParam Long id) {
		return skillService.getById(id);
	}

	@PostMapping("/add")
	public Skill add(@RequestBody Skill skill) {
		return skillService.add(skill);
	}

	@DeleteMapping("/delete/")
	public String deleteById(@RequestParam Long id) {
		return skillService.deleteById(id);
	}

	@PutMapping("/alter")
	public Skill alterById(@RequestBody Skill skill) {
		return skillService.alterById(skill);
	}

}
