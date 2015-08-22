package pl.tbns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.tbns.dao.UserDao;
import pl.tbns.model.User;
import pl.tbns.service.UserService;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:38:12 PM
 * 
 */

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	public List<User> findAllUser() {
		return userDao.findAll();
	}

	public User findOneUser(Long id) {
		return userDao.findOne(id);
	}

}
