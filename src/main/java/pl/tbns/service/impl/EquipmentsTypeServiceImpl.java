package pl.tbns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.EquipmentsType;
import pl.tbns.service.EquipmentsTypeService;

/**
 * @author Szymon Iwanaski
 * @author Maciej Skowyra
 *
 */
@Service
@Transactional
public class EquipmentsTypeServiceImpl implements EquipmentsTypeService{

	@Autowired
	private EquipmentsTypeDao equipmentsTypeDao;

	public void createEquipmentsType(EquipmentsType eqipmentsType) {
		equipmentsTypeDao.save(eqipmentsType);
	}

	public void deleteEqiupmentsTypeById(Long id) {
		this.equipmentsTypeDao.delete(id);
	}

	public EquipmentsType getEquipmentsTypeById(Long id) {
		return this.equipmentsTypeDao.getOne(id);
	}

	public EquipmentsType findEquipmentsNoLazyLoadByIdWithoutEquipment(Long id) {
		return this.equipmentsTypeDao.getEquipmentsTypeLazyLoadById(id);
	}
	
	
	public void modifyEquipmentsType(EquipmentsType equipmentsType) {
		this.equipmentsTypeDao.saveAndFlush(equipmentsType);
	}

	
	public List<EquipmentsType> findAllEquipmentsType() {
		return equipmentsTypeDao.findAll();
	}
		
}
