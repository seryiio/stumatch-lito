package pe.edu.upc.stumatch.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@Column(name = "course_id")
	private String id;
	
	@Column(name = "name", length = 75, nullable = false)
	private String name;
	
	@Column(name = "number_cycle", columnDefinition = "NUMERIC(2)", nullable = false)
	private Integer numberCycle;
	
	@Column(name = "number_credits", columnDefinition = "NUMERIC(2)", nullable = false)
	private Integer numberCredits;
	
	@OneToMany(mappedBy = "course")
	private List<Section> sections;
	
	@ManyToOne
	@JoinColumn(name = "career_id")
	private Career career;
	
	public Course() {
		sections = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public Integer getNumberCycle() {
		return numberCycle;
	}

	public void setNumberCycle(Integer numberCycle) {
		this.numberCycle = numberCycle;
	}

	public Integer getNumberCredits() {
		return numberCredits;
	}

	public void setNumberCredits(Integer numberCredits) {
		this.numberCredits = numberCredits;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}
	
}
