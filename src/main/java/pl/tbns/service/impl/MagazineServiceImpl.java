package pl.tbns.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Magazine;
import pl.tbns.service.MagazineService;

/**
 * @author Szymon Iwanaski
 * @author Maciej Skowyra
 */

@Service
@Transactional
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MagazineDao magazineDao;
	
	public Magazine getMagazineByID(Long id) {
		return this.magazineDao.getOne(id);
	}

	public void createMagazine(Magazine magazine) {
		magazineDao.save(magazine);
	}

	public void modifyMagazine(Magazine magazine) {
		this.magazineDao.saveAndFlush(magazine);
	}

	public void deleteMagazineById(Long id) {
		this.magazineDao.delete(id);
	}

	public Magazine findMagazineById(Long id) {
		return this.magazineDao.getOne(id);
	}

	@Override
	public List<Magazine> findAllMagazine() {
		return this.magazineDao.findAll();
	}

}
