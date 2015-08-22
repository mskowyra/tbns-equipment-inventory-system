
package pl.tbns.service;

import pl.tbns.model.Equipment;

/**
 * @author Szymon Iwański
 *
 */
public interface EquipmentService {

	public Equipment getEquipmentById(Long id);
	public void createEquipment(Equipment equipment, Long equipmentsTypeId, Long magazineId);
	public void modifyEquipment(Equipment equipment, Long equipmentsTypeId, Long magazineId);
	public void modifyForHistoryTransmissionEquipment(Equipment equipment, Long magazineId);
	public void deleteEquipmentById(Long id);
	public Equipment findEquipmentById(Long id);
}
