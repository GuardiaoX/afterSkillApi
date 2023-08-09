package br.com.afterSkillApi.domains;

import br.com.afterSkillApi.security.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profileSkill")
public class UserSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_user_cd_id")
	private User user;

	@Column(name = "profSk_nm_level")
	private Integer level;

	@ManyToOne
	@JoinColumn(name = "fk_sk_cd_id")
	private Skill skill;

	public UserSkill() {
	}

	public UserSkill(Long id, User user, Integer level, Skill skill) {
		super();
		this.id = id;
		this.user = user;
		this.level = level;
		this.skill = skill;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setProfile(User user) {
		this.user = user;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

}
