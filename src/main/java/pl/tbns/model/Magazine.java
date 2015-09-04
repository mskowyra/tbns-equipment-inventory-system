package pl.tbns.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * @author Szymon Iwanski
 * @author Maciej Skowyra
 *
 */
@Entity
@Table(name = "magazine")
public class Magazine implements Serializable {

	private static final long serialVersionUID = 1816879387948066857L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "magazine_id", unique = true, nullable = false)
	private Long id;
	
	@OneToMany(mappedBy="magazine", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Equipment> equipment;
	
	@OneToMany(mappedBy = "sourceMagazine")
	private Set<TransmissionHistory> transmisHistFromSource = new HashSet<TransmissionHistory>();
	
	@OneToMany(mappedBy = "destMagazine")
	private Set<TransmissionHistory> transmisHistFormDest = new HashSet<TransmissionHistory>();
	
	private String name;
	
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable=false)
	private Date openDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateUpdated;
		
	@Temporal(TemporalType.TIMESTAMP)
	private Date closeDate;
	
	private boolean status = true;
	
	@Column(name = "magazineDescription")
	@Size(min = 0, max = 2000)
	private String description;
	
	public Magazine() {	}

	public Magazine(List<Equipment> equipment, String name, Date dateUpdated,
			Date openDate, Date closeDate, boolean status, String description) {
		super();
		this.equipment = equipment;
		this.name = name;
		this.dateUpdated = dateUpdated;
		this.openDate = openDate;
		this.closeDate = closeDate;
		this.status = status;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
				+ ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result
				+ ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((openDate == null) ? 0 : openDate.hashCode());
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
		Magazine other = (Magazine) obj;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
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
		if (openDate == null) {
			if (other.openDate != null)
				return false;
		} else if (!openDate.equals(other.openDate))
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
