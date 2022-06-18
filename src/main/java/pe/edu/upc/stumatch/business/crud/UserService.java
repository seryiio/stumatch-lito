package pe.edu.upc.stumatch.business.crud;


import java.util.Optional;

import pe.edu.upc.stumatch.model.entity.User;

public interface UserService extends CrudService<User, Integer> {
	Optional<User> findByUsername(String username);
}
