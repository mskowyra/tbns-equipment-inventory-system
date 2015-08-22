package pl.tbns.service;

import java.util.List;

import pl.tbns.model.User;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:37:57 PM
 * 
 */
public interface UserService {

	public List<User> findAllUser();
	public User findOneUser(Long id);
	void cteateUser(User user);
	void removeUser(Long id);
	
}
