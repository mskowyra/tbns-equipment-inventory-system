package pl.tbns.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tbns.model.User;
/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:09:36 PM
 * 
 */
public interface UserDao extends JpaRepository<User, Long> {

}
