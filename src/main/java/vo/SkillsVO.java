package vo;

import javax.persistence.Column;

public class SkillsVO {
	
	@Column(name="skill_name")
	private String skillName;
	
	private String proficiency;
	
	public SkillsVO() {}
	
	public SkillsVO(String skillName) {
		this.skillName = skillName;
	}
	
	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getProficiency() {
		return proficiency;
	}

	public void setProficiency(String proficiency) {
		this.proficiency = proficiency;
	}

}
