package pl.tbns.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * @author Maciej Skowyra 
 * @date Sep 15, 2015 11:40:29 PM
 * 
 */
@SuppressWarnings("serial")
public class UserDetailsAdapter extends User implements UserDetails {

	private User user;
	private String password;
	
	public User getUser() { return user; }	
	public Long getId() { return user.getId(); }	
	public String getFirstName() { return user.getFirst_name(); }	
	public String getLastName() { return user.getLast_name(); }	
	public String getFullName() { return user.getFullName(); }	
	public String getEmail() { return user.getEmail(); }	
	public UserDetailsAdapter(User user) {
		{
			this.user = user;			
		}		
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();			
			for (Role role : user.getRoles()) {				
				authorities.add( new SimpleGrantedAuthority(role.getName()));
			}	
		return authorities;
	}	

	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) { this.password = password; }

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}	
			
}

