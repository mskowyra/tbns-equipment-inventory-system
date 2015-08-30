
package pl.tbns.service;

import java.util.List;

import pl.tbns.model.Equipment;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 30, 2015 6:12:47 PM
 * 
 */
public interface EquipmentService {

	public Equipment getEquipmentById(Long id);
	public List<Equipment> findAllEquipment();
	public Equipment createEquipment(Equipment equipment);
	public void createEquipmentSetTypeSetMagazine(Equipment equipment, Long equipmentsTypeId, Long magazineId);
	public void modifyEquipment(Equipment equipment, Long equipmentsTypeId, Long magazineId);
	public void modifyForHistoryTransmissionEquipment(Equipment equipment, Long magazineId);
	public void deleteEquipmentById(Long id);
	public Equipment findEquipmentById(Long id);
}
