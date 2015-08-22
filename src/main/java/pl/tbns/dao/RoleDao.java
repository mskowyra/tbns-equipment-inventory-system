package pl.tbns.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tbns.model.Role;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:19:41 PM
 * 
 */
public interface RoleDao extends JpaRepository<Role, Long>{

	Role findByName(String name);
}
