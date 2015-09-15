package pl.tbns.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.UserDetailsDao;
import pl.tbns.model.User;
import pl.tbns.model.UserDetailsAdapter;
import pl.tbns.service.UserService;


/**
 * @author Maciej Skowyra 	
 * @date Sep 15, 2015 11:40:39 PM
 * 
 */
@Service
@Transactional(readOnly=true)
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserService userService;
	@Autowired
	private UserDetailsDao userDetailsDao; 
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        User user = userService.findOneUserByName(username);
       
        if(user==null){
          
            throw new UsernameNotFoundException("Username not found");
        }else if (user.getRoles().isEmpty()){
        	throw new UsernameNotFoundException("User " + username + " has no authorities");
        }
            UserDetailsAdapter userNew = new UserDetailsAdapter(user);
            userNew.setPassword(userDetailsDao.findPasswordByUsername(username));
            return userNew;
    }
 
/*    
    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(Role role : user.getRoles()){
            System.out.println("UserRoles : "+role);
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
*/
}

