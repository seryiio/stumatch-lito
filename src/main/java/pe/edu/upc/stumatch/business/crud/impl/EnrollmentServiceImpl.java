package pe.edu.upc.stumatch.business.crud.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.model.repository.EnrollmentRepository;
import pe.edu.upc.stumatch.business.crud.EnrollmentService;
import pe.edu.upc.stumatch.model.entity.Enrollment;
import pe.edu.upc.stumatch.model.entity.Section;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public JpaRepository<Enrollment, Integer> getJpaRepository() {
		return this.enrollmentRepository;
	}
	
	@Override
	public List<String[]> Reporte1(){
		return this.enrollmentRepository.Reporte1();
	}
	
	@Override
    public Integer insert(Enrollment enrollment) {
       /* int rpta = enrollmentRepository.BuscarCurso(enrollment.getSection().getCourse().getId(),enrollment.getStudent().getId());
        if (rpta == 0) {
        	enrollmentRepository.save(enrollment);
        }
        return rpta;*/
        
        int CursosRepetidos=0;
       CursosRepetidos = this.enrollmentRepository.BuscarCurso(enrollment.getSection().getCourse().getId(), enrollment.getStudent().getId());
       if (CursosRepetidos==0)
       {
    	   enrollmentRepository.save(enrollment);
       }
       
       
       
       
       for (int i =0 ; i<20 ; i++) {
        System.out.println(enrollment.getSection().getCourse().getId());
        System.out.println(enrollment.getStudent().getId());
        System.out.println(CursosRepetidos);
        }
       return CursosRepetidos;
        
        
        
    }
}
