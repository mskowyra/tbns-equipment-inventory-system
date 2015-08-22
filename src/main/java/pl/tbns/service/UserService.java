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
	public User findOneUserById(Long id);
	public User findOneUserByName(String username);
	void cteateUser(User user);
	void removeUser(Long id);
	
}
