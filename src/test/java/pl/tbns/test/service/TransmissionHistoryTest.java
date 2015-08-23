package pl.tbns.test.service;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.EquipmentDao;
import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Equipment;
import pl.tbns.model.Magazine;
import pl.tbns.model.TransmissionHistory;
import pl.tbns.service.TransmissionHistoryService;

/**
 * @author Maciej Skowyra
 * 
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-context-test.xml", "/spring/hibernate-context-test.xml" })
public class TransmissionHistoryTest extends TestCase{
	
	@Autowired
	private MagazineDao magazineDao;
	@Autowired
	private EquipmentDao equipmentDao;
	@Autowired
	private TransmissionHistoryService transmissionHistoryService; 
	
	@Before
	@Transactional
	public void setUp() {
		
		Equipment equipment1 = new Equipment();
		equipment1.setName("Basic equipment 1 ");
		equipmentDao.save(equipment1);
		
		Equipment equipment2 = new Equipment();
		equipment2.setName("Basic equipment 1 ");
		equipmentDao.save(equipment2);
		
		Magazine magazine = new Magazine();
		magazine.setName("Magazine 1");
		magazineDao.save(magazine);
		
		Magazine magazine2 = new Magazine();
		magazine2.setName("Magazine 2");
		magazineDao.save(magazine2);
		
		Magazine magazine3 = new Magazine();
		magazine3.setName("Magazine 3");
		magazineDao.save(magazine3);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void createTransmissionHistorTest(){
		Long equipmentId = equipmentDao.findAll().get(0).getId();
		Long sourceMagazineId = magazineDao.findAll().get(0).getId();
		Long destMagazineId = magazineDao.findAll().get(0).getId();
		
		TransmissionHistory transmissionHistory = new TransmissionHistory();
		transmissionHistory.setDescription("Some History record");
		
		transmissionHistoryService.createTransmissionHistory(transmissionHistory, equipmentId, sourceMagazineId, destMagazineId);	
		Assert.assertNotNull("No transmission history created", transmissionHistoryService.getTransmissionHistoryById(transmissionHistory.getId()));
	}
	
}
