package pl.tbns.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class UserServiceImpl implements UserService{

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	public List<User> findAllUser() {
		return userDao.findAll();
	}

	public User findOneUserById(Long id) {
		return userDao.findOne(id);
	}
	
	public User findOneUserByName(String username) {
        return userDao.findByName(username);
    }

	public void createUser(User user) {
		user.setStatus(true);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleDao.findByName("ROLE_USER"));
        user.setRoles(roles);
        logger.info("Utworzono nowego urzytkownika");
        userDao.saveAndFlush(user);
		
	}
	
	public void saveUserAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		userDao.updateAdminPassword(encodedPassword);
		userDao.updateAdminName(user.getName());
	}

	public void removeUser(Long id) {
	    userDao.delete(id);
	}
	
	public User findAdmin() {
		return userDao.findAdmin();
	}
}
