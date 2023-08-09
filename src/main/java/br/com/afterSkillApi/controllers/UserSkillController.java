package br.com.afterSkillApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.afterSkillApi.domains.UserSkill;
import br.com.afterSkillApi.dto.SkillDto;
import br.com.afterSkillApi.services.UserSkillService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "Bearer Auth")
@RequestMapping("/userSkill")
public class UserSkillController {

	@Autowired
	UserSkillService userSkillService;

	@PostMapping("/addTo")
	public String addSkillTo(@RequestParam Integer userId, Integer level, Long SkillId) {
		return userSkillService.addSkillTo(userId, level, SkillId);
	}

	@GetMapping("/SkillListFrom/")
	public List<SkillDto> getUserSkills(@RequestParam Integer userId) {
		return userSkillService.getUserSkills(userId);
	}

	@PutMapping("/AlterSkillLevel/")
	public UserSkill alterLevel(@RequestParam Integer userId, Long skillId, Integer newLevel) {
		return userSkillService.alterLevel(userId, skillId, newLevel);
	}

	@DeleteMapping("/DeleteFrom/")
	public String deleteByIds(@RequestParam Integer userId, Long skillId) {
		return userSkillService.deleteByIds(userId, skillId);
	}
}
