package pl.tbns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.EquipmentsType;
import pl.tbns.model.Magazine;
import pl.tbns.service.EquipmentService;

/**
 * @author Maciej Skowyra
 * @author Szymon Iwanaski
 *
 */
@Service
@Transactional
public class EquipmentServiceImpl implements EquipmentService {

	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private EquipmentsTypeDao equipmentsTypeDao;
	@Autowired
	private MagazineDao magazineDao;

	public Equipment getEquipmentById(Long id) {
		return this.equipmentDao.getOne(id);
	}
	

	public List<Equipment> findAllEquipment() {
		return equipmentDao.findAll();
	}
	
	public List<Equipment> findbyMagazine(Long id) {
		return equipmentDao.findbyMagazine(id);
	}
	
	public Equipment getEquipmenLazyLoadById(Long id){
		return equipmentDao.getEquipmenLazyLoadById(id);
	}
	
	@Override
	public Equipment createEquipment(Equipment equipment, Long equipmentsTypeId) {
		EquipmentsType equipmentsType = equipmentsTypeDao.getOne(equipmentsTypeId);
		equipment.setEquipmentsType(equipmentsType);		
		return equipmentDao.saveAndFlush(equipment);		
	}
	
	public Equipment createEquipmentSetTypeSetMagazine(Equipment equipment, Long equipmentsTypeId,Long magazineId) {
		EquipmentsType equipmentsType = equipmentsTypeDao.getOne(equipmentsTypeId);
		Magazine magazine = magazineDao.getOne(magazineId);
		equipment.setEquipmentsType(equipmentsType);
		equipment.setMagazine(magazine);
		return equipmentDao.saveAndFlush(equipment);		
	}

	public void modifyEquipment(Equipment equipment, Long equipmentsTypeId,
			Long magazineId) {
		
	}
	
	public void modifyForHistoryTransmissionEquipment(Equipment equipment, Long magazineId) {		
	
	}

	public void deleteEquipmentById(Long id) {
		this.equipmentDao.delete(id);
	}

	public Equipment findEquipmentById(Long id) {
		return this.equipmentDao.getOne(id);
	}

	
		

}
