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

import pl.tbns.dao.EquipmentsTypeDao;
import pl.tbns.model.EquipmentsType;
import pl.tbns.service.EquipmentsTypeService;

/**
 * @author Szymon Iwański
 * @author Maciej Skowyra
 *
 */
//@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {  "/spring/spring-application-context.xml", "/spring/store/spring-data-dev.xml" })
public class EquipmentsTypeServiceTest extends TestCase{

	@Autowired
	private EquipmentsTypeService equipmentsTypeService;
	@Autowired
	private EquipmentsTypeDao equipmentsTypeDao;
	
	@Test
	@Transactional
//	@Rollback(false)
	public void testCreateEquipmentsType() {
		EquipmentsType equipmentsType = new EquipmentsType();
		equipmentsType.setName("Basic equipments type created ");
		
		equipmentsTypeService.createEquipmentsType(equipmentsType);
		
		Assert.assertNotNull(
				"No equipments type added", equipmentsTypeService.getEquipmentsTypeById(equipmentsType.getId()));
	}
	@Ignore
	@Test
	@Transactional
	public void testDeleteEquipmentsType() {
		EquipmentsType equipmentsType = new EquipmentsType();
		equipmentsType.setName("Basic equipments type for delete");
		
		equipmentsTypeService.createEquipmentsType(equipmentsType);
		equipmentsTypeService.deleteEqiupmentsTypeById(equipmentsTypeDao.findAll().get(0).getId());
		
		Assert.assertNull(
				"Error! No equipments type deleted", equipmentsTypeService.getEquipmentsTypeById(equipmentsType.getId()));
	}
}
