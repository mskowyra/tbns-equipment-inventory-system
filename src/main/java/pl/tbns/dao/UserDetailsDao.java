package pl.tbns.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.tbns.model.User;


/**
 * @author Maciej Skowyra 
 * @date Sep 15, 2015 11:40:52 PM
 * 
 */
public interface UserDetailsDao extends JpaRepository<User, Long> {

	@Query(" SELECT password FROM User WHERE name = :name ")
	public String findPasswordByUsername(@Param("name") String username);
}
