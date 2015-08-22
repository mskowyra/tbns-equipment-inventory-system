package pl.tbns.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tbns.model.Equipment;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 11:23:44 PM
 * 
 */
public interface EquipmentsDao extends JpaRepository<Equipment, Long>{

}
