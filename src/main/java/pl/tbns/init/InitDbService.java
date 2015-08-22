package pl.tbns.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.RoleDao;
import pl.tbns.dao.UserDao;
import pl.tbns.model.Role;
import pl.tbns.model.User;


/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:49:30 PM
 * 
 */
@Service
@Transactional
public class InitDbService {

	@Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    

    @PostConstruct
    public void init() {
        Role roleUser = new Role();
        roleUser.setName("ROLE_USER");
        roleDao.save(roleUser);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleDao.save(roleAdmin);

        User userAdmin = new User();
        userAdmin.setName("admin");
        userAdmin.setPassword("admin");
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userDao.save(userAdmin);
        
    }
}
