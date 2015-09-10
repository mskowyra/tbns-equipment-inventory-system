package pl.tbns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.dao.TransmissionHistoryDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.Magazine;
import pl.tbns.model.TransmissionHistory;
import pl.tbns.service.EquipmentService;
import pl.tbns.service.TransmissionHistoryService;

/**
 * @author Maciej Skowyra
 * @author Szymon Iwanski
 *
 */
@Service
@Transactional
public class TransmissionHistoryServiceImpl implements
		TransmissionHistoryService {

	@Autowired
	private TransmissionHistoryDao transmissionHistoryDao;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private MagazineDao magazineDao;
	
		
	public TransmissionHistory getTransmissionHistoryById(Long id) {
		return this.transmissionHistoryDao.getOne(id);
	}
	
	public List<TransmissionHistory> findbyMagazine(Long magazineId) {
		return transmissionHistoryDao.findbyMagazine(magazineId);
	}
	
	public void createTransmissionHistory(Equipment equipment,	Long sourceMagazineId) {
		 TransmissionHistory transmissionHistory = new TransmissionHistory();
		 transmissionHistory.setEquipment(equipment);
		 Magazine sourceMagazine = magazineDao.getOne(sourceMagazineId);
		 transmissionHistory.setSourceMagazine(sourceMagazine);
		 transmissionHistoryDao.save(transmissionHistory);
	}

	/*
	 * Trzeba rozkmini� jak pobra� id magazynu bierz�cego bezpo�rednio z equipment 
	 * a nie podawa� go w parametrze.
	 * Problem jest �e Magazyn w Equipment jest typu List<Magazine>
	 * a my musimy poda� w sourceMagazine typu Magazine
	 */
	public void createTransmissionHistory(
			TransmissionHistory transmissionHistory, Long equipmentId,
			Long sourceMagazineId, Long destMagazineId) {
		
			Equipment equipment = equipmentDao.getOne(equipmentId);
		
			Magazine sourceMagazine = magazineDao.getOne(sourceMagazineId);
			Magazine destMagazine = magazineDao.getOne(destMagazineId);
					
			transmissionHistory.setEquipment(equipment);
			transmissionHistory.setSourceMagazine(sourceMagazine);
			transmissionHistory.setDestMagazine(destMagazine);
			
			transmissionHistoryDao.save(transmissionHistory);
	}

	public void changeStatusTransmissionHistory(Long id, boolean status) {
			TransmissionHistory transmissionHistory = transmissionHistoryDao.getOne(id);
			
			if(status == true){
					Long destMagazine = transmissionHistory.getDestMagazine().getId();
					Equipment equipment = transmissionHistory.getEquipment();
					
					//update id magazine in equipment after change status on true in history 
					equipmentService.modifyForHistoryTransmissionEquipment(equipment, destMagazine);
					//update status in history 
					transmissionHistoryDao.saveAndFlush(transmissionHistory);
			}
		
	}
		
	public void modifyTransmissionHistory(TransmissionHistory transmissionHistory, Long equipmentId,
			Long sourceMagazineId, Long destMagazineId) {

	}

	public void deleteTransmissionHistoryById(Long id) {
		this.transmissionHistoryDao.delete(id);
	}

	public TransmissionHistory findTransmissionHistoryById(Long id) {
		return this.transmissionHistoryDao.getOne(id);
	}	
}
