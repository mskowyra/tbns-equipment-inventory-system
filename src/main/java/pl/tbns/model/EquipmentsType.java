package pl.tbns.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;



/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
@Entity
@Table(name = "EquipmentsType")
public class EquipmentsType implements Serializable {

	private static final long serialVersionUID = 4935079054169283360L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "equipmentsType_id", nullable = false)
	private long id;

	@Column(name = "equipmentsTypeName")
	@Size(min = 5, max = 100, message = "Nazwa nie może być krótsza niż 5 i dłuższa niż 100 znaków!")
	private String name;

	@Column(name = "equipmentsTypeDescription")
	@Size(min = 0, max = 2000)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "equipmentsType")
	private List<Equipment> equipment = new ArrayList<Equipment>(0);

	public EquipmentsType() {
		
	}

	public EquipmentsType(String name, String description,
			List<Equipment> equipment) {
		this.name = name;
		this.description = description;
		this.equipment = equipment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Equipment> getEquipment() {
		return equipment;
	}

	public void setEquipment(List<Equipment> equipment) {
		this.equipment = equipment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((equipment == null) ? 0 : equipment.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		EquipmentsType other = (EquipmentsType) obj;
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}	
}
