package br.com.afterSkillApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.afterSkillApi.domains.UserSkill;

public interface UserSkillRepository extends JpaRepository<UserSkill, Long>{

}
