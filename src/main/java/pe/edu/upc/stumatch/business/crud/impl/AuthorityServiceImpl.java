package pe.edu.upc.stumatch.business.crud.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import pe.edu.upc.stumatch.business.crud.AuthorityService;
import pe.edu.upc.stumatch.model.entity.Authority;
import pe.edu.upc.stumatch.model.repository.AuthorityRepository;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityRepository aR;

	@Override
	public JpaRepository<Authority, Long> getJpaRepository() {
		return this.aR;
	}
	
}
