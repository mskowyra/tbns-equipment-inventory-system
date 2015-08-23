package pl.tbns.test.service;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.tbns.dao.MagazineDao;
import pl.tbns.model.Magazine;
import pl.tbns.service.MagazineService;

/**
 * @author Maciej Skowyra
 * @author Szymon Iwański
 *
 */
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/application-context-test.xml", "/spring/hibernate-context-test.xml" })
public class MagazineServiceTest extends TestCase{

	@Autowired
	private MagazineService magazineService;
	@Autowired
	private MagazineDao magazineDao;
	
	
	@Test
	@Transactional
//	@Rollback(false)
	public void testCreateMagazine() {
		Magazine magazine = new Magazine();
		magazine.setName("Simple magazine test create");
		
		magazineService.createMagazine(magazine);
		
		Assert.assertNotNull("No magazine added", magazineService.findMagazineById(magazine.getId()));
	}
	@Ignore
	@Test
	@Transactional
//	@Rollback(false)
	public void testDeleteMagazine() {
		Magazine magazine = new Magazine();
		magazine.setName("Simple magazine for delete");
		
		magazineService.createMagazine(magazine);
		magazineService.deleteMagazineById(magazineDao.findAll().get(0).getId());
		
		Assert.assertNull("Error! No magazine deleted", magazineService.findMagazineById(magazine.getId()));
	}
}
