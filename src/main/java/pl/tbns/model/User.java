package pl.tbns.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Email;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:05:20 PM
 * 
 */
@Entity
public class User  {

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Long id;
    @Size(min = 3, message = "Name must be at least 3 characters!")
    private String name;
    @Email(message = "Invalid e-mail address!")
    @Size(min = 3, message = "E-mail must be at least 3 characters!")
    private String email;
    @Size(min = 5, message = "Password must be at least 5 characters!")
    private String password;
    private String first_name;
	private String last_name;
	private Boolean isEnabled;
    private boolean status;
    private long phone;
    
    @ManyToMany
    @JoinTable
    private List<Role> roles;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable=false)
	private Date dateCreate;
    @UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdate;
	
	@OneToMany(mappedBy = "sourceUser", fetch = FetchType.LAZY)
	private List<TransmissionHistory> transmisHistFromSource = new ArrayList<TransmissionHistory>();
	
	@OneToMany(mappedBy = "destUser", fetch = FetchType.LAZY)
	private Set<TransmissionHistory> transmisHistFormDest = new HashSet<TransmissionHistory>();	
    
	 public User(){   
	    };	       

	public User(String name, String password, Boolean isEnabled, List<Role> roles) {
			super();
			this.name = name;
			this.password = password;
			this.isEnabled = isEnabled;
			this.roles = roles;
		}	
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@CreationTimestamp
	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return dateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate;
	}

	public List<TransmissionHistory> getTransmisHistFromSource() {
		return transmisHistFromSource;
	}

	public void setTransmisHistFromSource(
			List<TransmissionHistory> transmisHistFromSource) {
		this.transmisHistFromSource = transmisHistFromSource;
	}

	public Set<TransmissionHistory> getTransmisHistFormDest() {
		return transmisHistFormDest;
	}

	public void setTransmisHistFormDest(
			Set<TransmissionHistory> transmisHistFormDest) {
		this.transmisHistFormDest = transmisHistFormDest;
	}
	public Boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
	@Transient
	public String getFullName() { return first_name + " " + last_name; }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	   
}
