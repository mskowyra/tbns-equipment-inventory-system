package pl.tbns.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
@Entity
@Table(name = "TransmissionHistory")
public class TransmissionHistory implements Serializable {

	private static final long serialVersionUID = -6545040713713942954L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transmisHist_id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "equipment_id")
	private Equipment equipment;
	
	@ManyToOne
	@JoinColumn(name = "sourceMagazine_id")
	private Magazine sourceMagazine; //magazyn źródłowy
	
	@ManyToOne
	@JoinColumn(name = "destMagazine_id")
	private Magazine destMagazine; //magazyn docelowy
	
	@ManyToOne
	@JoinColumn(name = "sourceUser_id")
	private User sourceUser; //urzytkownik źródłowy
	
	@ManyToOne
	@JoinColumn(name = "destUser_id")
	private User destUser; //urzytkownik docelowy
	
	@Temporal(TemporalType.DATE)
	private Date transmisDate; //data wydania dyspozycji do przekazania sprzetu
	
	@Temporal(TemporalType.DATE)
	private Date acceptDate; //data przyjęcia sprzętu na magazyn
	
	@Temporal(TemporalType.DATE)
	private Date rejectDate; //data odrzucenia sprzętu z magazynu
	
	private boolean status = false;
	
	@Column(name = "equipmentDescription")
	@Size(min = 0, max = 2000)
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date DateCreated;

	public TransmissionHistory() {
	}

	public TransmissionHistory(Equipment equipment, Magazine sourceMagazine,
			Magazine destMagazine, Date transmisDate, Date acceptDate,
			Date rejectDate, Boolean status, String description,
			Date dateCreated) {
		this.equipment = equipment;
		this.sourceMagazine = sourceMagazine;
		this.destMagazine = destMagazine;
		this.transmisDate = transmisDate;
		this.acceptDate = acceptDate;
		this.rejectDate = rejectDate;
		this.status = status;
		this.description = description;
		DateCreated = dateCreated;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Magazine getSourceMagazine() {
		return sourceMagazine;
	}

	public void setSourceMagazine(Magazine sourceMagazine) {
		this.sourceMagazine = sourceMagazine;
	}

	public Magazine getDestMagazine() {
		return destMagazine;
	}

	public void setDestMagazine(Magazine destMagazine) {
		this.destMagazine = destMagazine;
	}

	public Date getTransmisDate() {
		return transmisDate;
	}

	public void setTransmisDate(Date transmisDate) {
		this.transmisDate = transmisDate;
	}

	public Date getAcceptDate() {
		return acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	public Date getRejectDate() {
		return rejectDate;
	}

	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
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

	public Date getDateCreated() {
		return DateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		DateCreated = dateCreated;
	}

	public User getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}

	public User getDestUser() {
		return destUser;
	}

	public void setDestUser(User destUser) {
		this.destUser = destUser;
	}

	
}
