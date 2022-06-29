package pe.edu.upc.stumatch.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.stumatch.model.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer>{
	
	@Query(value= "SELECT students.student_id,students.first_name, students.last_name,email_university,email_personal,phone_number,cycle, career_id  FROM Students INNER JOIN Enrollments ON Students.student_id=Enrollments.student_id GROUP BY Students.student_id", nativeQuery = true)
	public List<String[]> Reporte1();
	
	//@Query("select count(s.course) from Enrollment e inner join Section s on e.section=s.id where s.course=:curso and e.student=:alumno group by e.student")
	//public int BuscarCurso(@Param("curso") String curso,@Param("alumno") String alumno);
	
	@Query(	value="select count(s.course_id) from enrollments e inner join sections s on e.section_id=s.section_id where s.course_id=:curso and e.student_id=:alumno", nativeQuery = true )
	public int BuscarCurso(@Param("curso") String curso,@Param("alumno") String alumno);

	@Query(value="select s.vacancies from sections s where s.section_id=:seccion", nativeQuery = true )
	public int BuscarVacantes(@Param("seccion") String seccion);
	
	@Query(value="select s.credit_amount from students s where s.student_id=:estudiante", nativeQuery = true )
	public int BuscarCreditos(@Param("estudiante") String estudiante);
	
}

