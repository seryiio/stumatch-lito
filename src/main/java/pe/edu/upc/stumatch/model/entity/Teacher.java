package pe.edu.upc.stumatch.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers", indexes = {@Index(columnList = "last_name, first_name", name = "teachers_index_last_name_first_name")})
public class Teacher {
	@Id
	@Column(name = "teacher_id", length = 12, nullable = false)
	private String id;
	
	@Column(name = "last_name", length = 50, nullable = false)
	private String lastName;
	
	@Column(name = "first_name", length = 50, nullable = false)	
	private String firstName;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "dni",columnDefinition = ("NUMERIC(8)"), nullable = false)	
	private int dni;
	
	@Column(name = "phone_number",columnDefinition = ("NUMERIC(9)"), nullable = false)
	private int phoneNumber;
	
	@Column(name = "email_university", length = 70)	
	private String emailUniversity;
	
	@ManyToOne
	@JoinColumn(name = "career_id")
	private  Career career;
	
	@OneToMany(mappedBy = "teacher")
	private List<Section> sections;
	
	public Teacher() {
		sections = new ArrayList<>();
	}

	
	public List<Section> getSections() {
		return sections;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getEmailUniversity() {
		return emailUniversity;
	}

	public void setEmailUniversity(String emailUniversity) {
		this.emailUniversity = emailUniversity;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public List<Section> getSection() {
		return sections;
	}

	public void setSection(List<Section> section) {
		this.sections = section;
	}
	
	
}
