package pl.tbns.test.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

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


//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/spring-application-context-test.xml", "/spring/store/hibernate-context-test.xml" })
public class CreateUserAndRoleTest extends TestCase{

	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private UserDao userDao;

	@Test
	@Transactional
//	@Rollback(false)
	public void init(){
		Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleDao.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleDao.save(roleAdmin);

        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        
        User userAdmin = new User();
        userAdmin.setStatus(true);
        userAdmin.setName("admin");        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userAdmin.setPassword(encoder.encode("admin"));
        userAdmin.setRoles(roles);
        userDao.save(userAdmin);
        
	}
}
