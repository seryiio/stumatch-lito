package pe.edu.upc.stumatch.business.crud;

import java.util.List;

import pe.edu.upc.stumatch.model.entity.Enrollment;
import pe.edu.upc.stumatch.model.entity.Section;

public interface EnrollmentService extends CrudService<Enrollment, Integer>{
	public List<String[]> Reporte1();

	public Integer insert(Enrollment enrollment);
}
