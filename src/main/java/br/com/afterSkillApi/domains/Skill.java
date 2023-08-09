package br.com.afterSkillApi.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sk_cd_id")
	private Long Id;
	
	@Column(name = "sk_tx_name")
	private String name;
	
	@Column(name = "sk_tx_desc")
	private String desc;
	
	@Column(name = "sk_tx_photo")
	private String photo;

	public Skill() {
	}

	public Skill(Long id, String name, String desc, String photo) {
		super();
		Id = id;
		this.name = name;
		this.desc = desc;
		this.photo = photo;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

}