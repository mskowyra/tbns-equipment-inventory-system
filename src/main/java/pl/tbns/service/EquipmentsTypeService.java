/**
 * 
 */
package pl.tbns.service;

import pl.tbns.model.EquipmentsType;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
public interface EquipmentsTypeService {

	public EquipmentsType getEquipmentsTypeById(Long id);
	public void createEquipmentsType(EquipmentsType equipmentsType);
	public void modifyEquipmentsType(EquipmentsType equipmentsType);
	public void deleteEqiupmentsTypeById(Long id);
	public EquipmentsType findEquipmentsTypeById(Long id);
}
