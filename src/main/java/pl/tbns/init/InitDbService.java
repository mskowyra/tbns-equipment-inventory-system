package pl.tbns.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        
        Role roleModerator = new Role();
        roleModerator.setName("ROLE_MODERATOR");
        roleDao.save(roleModerator);

        Role roleAdmin = new Role();
        roleAdmin.setName("ROLE_ADMIN");
        roleDao.save(roleAdmin);

        User userUser = new User();
        userUser.setStatus(true);
        userUser.setName("user");
        BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
        userUser.setPassword(encoder2.encode("user"));
        List<Role> rolesUser = new ArrayList<Role>();
        rolesUser.add(roleUser);
        userUser.setRoles(rolesUser);
        userDao.save(userUser);
        
        User userModerator = new User();
        userModerator.setStatus(false);
        userModerator.setName("moderator");
        BCryptPasswordEncoder encoder3 = new BCryptPasswordEncoder();
        userModerator.setPassword(encoder3.encode("moderator"));
        List<Role> rolesModerator = new ArrayList<Role>();
        rolesModerator.add(roleUser);
        rolesModerator.add(roleModerator);
        userModerator.setRoles(rolesModerator);
        userDao.save(userModerator);
        
        User userAdmin = new User();
        userAdmin.setStatus(true);
        userAdmin.setName("admin");  
        userAdmin.setFirst_name("Maciej");
        userAdmin.setLast_name("Skowyra");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userAdmin.setPassword(encoder.encode("admin"));
        List<Role> roles = new ArrayList<Role>();
        roles.add(roleAdmin);
        roles.add(roleModerator);
        roles.add(roleUser);
        userAdmin.setRoles(roles);
        userDao.save(userAdmin);
        
    }
}
