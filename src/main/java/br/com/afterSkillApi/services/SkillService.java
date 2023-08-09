package br.com.afterSkillApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.afterSkillApi.domains.Skill;
import br.com.afterSkillApi.repositories.SkillRepository;

@Service
public class SkillService {

	@Autowired
	SkillRepository skillrepository;

	public List<Skill> getAll() {
		return skillrepository.findAll();
	}

	public Skill getById(Long id) {
		return skillrepository.findById(id).get();
	}

	public Skill add(Skill skill) {
		return skillrepository.save(skill);
	}

	public String deleteById(Long id) {
		skillrepository.deleteById(id);
		return "Skill deletada com sucesso";
	}

	public Skill alterById(Skill skill) {
		return skillrepository.save(skill);
	}
}
