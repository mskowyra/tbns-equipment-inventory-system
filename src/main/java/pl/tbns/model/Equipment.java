
package pl.tbns.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;


/**
 * @author Szymon Iwanski
 * @author Maciej Skowyra
 *
 */
@Entity
@Table(name = "Equipment")
public class Equipment implements Serializable {

	private static final long serialVersionUID = -6064036581679301930L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "equipment_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "equipmentName")
	@Size(min = 5, max = 100, message = "Nazwa nie może być krótsza niż 5 i dłuższa niż 100 znaków!")
	private String name;
	
	@Column(name = "serialNumber")
	@Size(min = 2, max = 100, message = "Numer nie może być krótszy niż 2 i dłuższy niż 100 znaków!")
	private String serialNumber;
	
	@Column(name = "equipmentsNumber")
	@Size(min = 2, max = 100, message = "Numer nie może być krótszy niż 2 i dłuższy niż 100 znaków!")
	private String equipmentsNumber;
	
	@Column(name = "equipmentDescription")
	@Size(min = 0, max = 2000)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipmentsType_id", nullable = false)
	private EquipmentsType equipmentsType;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "magazine_equipment",
			joinColumns = {@JoinColumn(name = "magazine_id")},
			inverseJoinColumns = {@JoinColumn(name = "equipment_id")}
			)
	private List<Magazine> magazine;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateCreated;
	
	@OneToMany(mappedBy="equipment")
	private Set<TransmissionHistory> traansmisHistory;
	
	public Equipment() {
		
	}

	public Equipment(String name, String serialNumber, String equipmentsNumber,
			String description,EquipmentsType equipmentsType) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
		this.equipmentsNumber = equipmentsNumber;
		this.description = description;
		this.equipmentsType = equipmentsType;
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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getEquipmentsNumber() {
		return equipmentsNumber;
	}

	public void setEquipmentsNumber(String equipmentsNumber) {
		this.equipmentsNumber = equipmentsNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EquipmentsType getEquipmentsType() {
		return equipmentsType;
	}

	public void setEquipmentsType(EquipmentsType equipmentsType) {
		this.equipmentsType = equipmentsType;
	}

	public List<Magazine> getMagazine() {
		return magazine;
	}

	public void setMagazine(List<Magazine> magazine) {
		this.magazine = magazine;
	}

	public Date getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}

	public Set<TransmissionHistory> getTraansmisHistory() {
		return traansmisHistory;
	}

	public void setTraansmisHistory(Set<TransmissionHistory> traansmisHistory) {
		this.traansmisHistory = traansmisHistory;
	}

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
		Equipment other = (Equipment) obj;
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

	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", serialNumber="
				+ serialNumber + ", equipmentsNumber=" + equipmentsNumber
				+ ", description=" + description + ", equipmentsType="
				+ equipmentsType + ", magazine=" + magazine + ", DateCreated="
				+ DateCreated + ", traansmisHistory=" + traansmisHistory + "]";
	}

	
	
}
