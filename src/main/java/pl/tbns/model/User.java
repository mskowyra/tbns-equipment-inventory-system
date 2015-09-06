package pl.tbns.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	/*
	@PrePersist
	  protected void onCreate() {
		dateCreate = new Date();
	  }

	  @PreUpdate
	  protected void onUpdate() {
		dateUpdate = new Date();
	  }
	*/	
	@OneToMany(mappedBy = "sourceUser")
	private Set<TransmissionHistory> transmisHistFromSource = new HashSet<TransmissionHistory>();
	
	@OneToMany(mappedBy = "destUser")
	private Set<TransmissionHistory> transmisHistFormDest = new HashSet<TransmissionHistory>();	
    
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

	public Set<TransmissionHistory> getTransmisHistFromSource() {
		return transmisHistFromSource;
	}

	public void setTransmisHistFromSource(
			Set<TransmissionHistory> transmisHistFromSource) {
		this.transmisHistFromSource = transmisHistFromSource;
	}

	public Set<TransmissionHistory> getTransmisHistFormDest() {
		return transmisHistFormDest;
	}

	public void setTransmisHistFormDest(
			Set<TransmissionHistory> transmisHistFormDest) {
		this.transmisHistFormDest = transmisHistFormDest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateCreate == null) ? 0 : dateCreate.hashCode());
		result = prime * result
				+ ((dateUpdate == null) ? 0 : dateUpdate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((first_name == null) ? 0 : first_name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((last_name == null) ? 0 : last_name.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime
				* result
				+ ((transmisHistFormDest == null) ? 0 : transmisHistFormDest
						.hashCode());
		result = prime
				* result
				+ ((transmisHistFromSource == null) ? 0
						: transmisHistFromSource.hashCode());
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
		if (dateCreate == null) {
			if (other.dateCreate != null)
				return false;
		} else if (!dateCreate.equals(other.dateCreate))
			return false;
		if (dateUpdate == null) {
			if (other.dateUpdate != null)
				return false;
		} else if (!dateUpdate.equals(other.dateUpdate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (first_name == null) {
			if (other.first_name != null)
				return false;
		} else if (!first_name.equals(other.first_name))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (last_name == null) {
			if (other.last_name != null)
				return false;
		} else if (!last_name.equals(other.last_name))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (status != other.status)
			return false;
		if (transmisHistFormDest == null) {
			if (other.transmisHistFormDest != null)
				return false;
		} else if (!transmisHistFormDest.equals(other.transmisHistFormDest))
			return false;
		if (transmisHistFromSource == null) {
			if (other.transmisHistFromSource != null)
				return false;
		} else if (!transmisHistFromSource.equals(other.transmisHistFromSource))
			return false;
		return true;
	}
	
	   
}
