package pl.tbns.dao.impl;


import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.model.Equipment;


public abstract class EquipmentDaoImpl extends HibernateDaoSupport implements EquipmentDao {

	public Equipment getEquipmenLazyLoadById(Long id){
		Equipment equipment = getOne(id);
			getHibernateTemplate().initialize(equipment.getEquipmentsType());
	return equipment;
	}
	
	
}
