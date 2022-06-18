package pe.edu.upc.stumatch.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.model.repository.EnrollmentRepository;
import pe.edu.upc.stumatch.business.crud.EnrollmentService;
import pe.edu.upc.stumatch.model.entity.Enrollment;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{
	
	@Autowired
	private EnrollmentRepository enrollmentRepository;
	
	@Override
	public JpaRepository<Enrollment, Integer> getJpaRepository() {
		return this.enrollmentRepository;
	}
}
