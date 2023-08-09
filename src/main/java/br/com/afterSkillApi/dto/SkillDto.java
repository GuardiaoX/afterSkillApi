package br.com.afterSkillApi.dto;

public class SkillDto {
	
	private Long id;
	private String name;
	private String desc;
	private String photo;
	private Integer level;
	
	public SkillDto() {
	}

	public SkillDto(Long id, String name, String desc, String photo, Integer level) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.photo = photo;
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
}
