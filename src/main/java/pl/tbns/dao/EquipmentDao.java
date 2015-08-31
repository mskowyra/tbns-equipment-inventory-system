package pl.tbns.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.tbns.model.Equipment;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 11:23:44 PM
 * 
 */
public interface EquipmentDao extends JpaRepository<Equipment, Long>{

	
	
}
