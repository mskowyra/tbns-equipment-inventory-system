package pl.tbns.dao.impl;


import org.springframework.orm.hibernate4.support.HibernateDaoSupport;


import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.EquipmentsType;


public abstract class EquipmentsTypeDaoImpl  extends HibernateDaoSupport implements EquipmentsTypeDao {

	
	/*
	 * No Lazy inicialization when we have FATCH LAZY in model class
	 * We get onle data from EquipmentType
	 * https://dzone.com/articles/lazyeager-loading-using
	 */
	
	public EquipmentsType getEquipmentsTypeLazyLoadById(Long id){
		EquipmentsType equipmentsType = getOne(id);
			getHibernateTemplate().initialize(equipmentsType.getEquipment());
	return equipmentsType;
	}
		
	
}
