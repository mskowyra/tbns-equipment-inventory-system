package pl.tbns.test.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.RoleDao;
import pl.tbns.dao.UserDao;
import pl.tbns.model.Role;
import pl.tbns.model.User;
import pl.tbns.service.UserService;


//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-application-context.xml", "/spring/store/spring-data-prod.xml" })
public class CreateUserAndRoleTest extends TestCase{

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;


	
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateUser(){
		User user = userDao.findByName("admin");
		
		user.setName("TEST");
		user.setEmail("maciej.skowyra.pl");
		user.setPassword("password");
		userService.createUser(user);
		
	//	assertEquals("TEST", userDao.findByName("admin").getName().toString());
		assertSame(user, userDao.findByName("TEST"));
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCreateUser(){
				
		User userUser = new User();
       
        userUser.setName("user2");
        userUser.setPassword("user");            
        userService.createUser(userUser);
		
	//	assertEquals("TEST", userDao.findByName("admin").getName().toString());
		assertSame(userUser, userDao.findByName("user2"));
	
	}
	
	
}
