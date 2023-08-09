package br.com.afterSkillApi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.afterSkillApi.domains.Skill;
import br.com.afterSkillApi.domains.UserSkill;
import br.com.afterSkillApi.dto.SkillDto;
import br.com.afterSkillApi.repositories.UserSkillRepository;
import br.com.afterSkillApi.security.domain.User;
import br.com.afterSkillApi.security.repositories.UserRepository;

@Service
public class UserSkillService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SkillService skillService;

	@Autowired
	UserSkillRepository userSkillRepository;
	
	public String addSkillTo(@RequestParam Integer userId, @RequestParam Integer level, @RequestParam Long skillID) {
		User user = userRepository.findById(userId).get();
		Skill skill = skillService.getById(skillID);
		UserSkill userSkill = new UserSkill(null, user, level, skill);
		userSkillRepository.save(userSkill);
		
		return "A skill "+skill.getName()+" foi adicionada à "+user.getUsername();
	}
	
	public List<SkillDto> getUserSkills(Integer userId){
		List<UserSkill> userSkillList = userSkillRepository.findAll();
		List<SkillDto> skillList = new ArrayList<>();
		
		for(UserSkill userSkill : userSkillList) {
			if(userSkill.getUser().getId() == userId) {
				skillList.add(skillParseToDto(userSkill.getSkill(), userSkill.getLevel()));
			}
		}
		
		return skillList;
	}
	
	public UserSkill alterLevel(Integer userId, Long skillId, Integer newLevel) {
		List<UserSkill> userSkillList = userSkillRepository.findAll();
		UserSkill userSkillAlt = new UserSkill();
		
		for(UserSkill userSkill : userSkillList) {
			if(userSkill.getUser().getId() == userId && userSkill.getSkill().getId() == skillId) {
				userSkillAlt = userSkill;
			}
		}
		
		userSkillAlt.setLevel(newLevel);
		return userSkillRepository.save(userSkillAlt);
	}

	public String deleteByIds(Integer userId, Long skillId) {
		List<UserSkill> userSkillList = userSkillRepository.findAll();
		UserSkill userSkillDel = new UserSkill();
		
		for(UserSkill userSkill : userSkillList) {
			if(userSkill.getUser().getId() == userId && userSkill.getSkill().getId() == skillId) {
				userSkillDel = userSkill;
			}
		}
		
		userSkillRepository.delete(userSkillDel);
		
		return "A Skill " + userSkillDel.getSkill().getName()+" foi removida de "+userSkillDel.getUser().getUsername();
	}
	
	public SkillDto skillParseToDto(Skill oldSkill, Integer level) {
		SkillDto newSkill = new SkillDto(oldSkill.getId(), oldSkill.getName(), oldSkill.getDesc(), oldSkill.getPhoto(),level);
		return newSkill;
	}
	
}
