package pl.tbns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pl.tbns.dao.RoleDao;
import pl.tbns.dao.UserDao;
import pl.tbns.model.Role;
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
	@Autowired
	private RoleDao roleDao;
	
	public List<User> findAllUser() {
		return userDao.findAll();
	}

	public User findOneUser(Long id) {
		return userDao.findOne(id);
	}

	public void cteateUser(User user) {
		user.setStatus(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleDao.findByName("ROLE_USER"));
        user.setRoles(roles);

        userDao.save(user);
		
	}

	public void removeUser(Long id) {
	    userDao.delete(id);
	}
}
