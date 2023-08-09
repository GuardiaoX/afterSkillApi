package br.com.afterSkillApi.repositories;

import br.com.afterSkillApi.domains.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long>{

}

