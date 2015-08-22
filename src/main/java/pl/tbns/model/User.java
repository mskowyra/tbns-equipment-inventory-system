package pl.tbns.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 3:05:20 PM
 * 
 */
@Entity
public class User {

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

    @ManyToMany
    @JoinTable
    private List<Role> roles;

    @Temporal(TemporalType.TIMESTAMP)
	private Date DateCreate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateUpdate;
	
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

	public Date getDateCreate() {
		return DateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		DateCreate = dateCreate;
	}

	public Date getDateUpdate() {
		return DateUpdate;
	}

	public void setDateUpdate(Date dateUpdate) {
		DateUpdate = dateUpdate;
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

   
}
