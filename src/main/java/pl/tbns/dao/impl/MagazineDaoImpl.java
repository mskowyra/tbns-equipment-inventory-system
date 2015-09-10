package pl.tbns.dao.impl;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Magazine;

public abstract class MagazineDaoImpl extends HibernateDaoSupport implements MagazineDao {
	
	public Magazine getMagazineLazyLoadById(Long id){
		Magazine magazine = getOne(id);
			getHibernateTemplate().initialize(magazine.getEquipment());
			
	return magazine;
	}


}
