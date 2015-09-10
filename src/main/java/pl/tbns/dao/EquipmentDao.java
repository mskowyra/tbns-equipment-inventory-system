package pl.tbns.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.tbns.model.Equipment;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 11:23:44 PM
 * 
 */
public interface EquipmentDao extends JpaRepository<Equipment, Long>{

	
	public Equipment getEquipmenLazyLoadById(Long id);

/*	
	@Query(value="SELECT * "
			+ "FROM TransmissionHistory "
			+ "JOIN  equipment "
			+ "ON TransmissionHistory.equipment_id = Equipment.equipment_id "
			+ "JOIN Magazine "
			+ "ON TransmissionHistory.sourceMagazine_id = :magazine_id ", nativeQuery=true )	
	public List<Equipment> findbyMagazine(@Param("magazine_id") Long magazineId);
}
*/


@Query("SELECT e, eT, t "
			+ "FROM Equipment e "
			+ "LEFT JOIN fetch e.equipmentsType eT "
			+ "LEFT JOIN fetch e.transmisHistory t "
			+ "WHERE t.sourceMagazine =(SELECT m FROM Magazine m WHERE m.id = :magazine_id) ")	
	public List<Equipment> findbyMagazine(@Param("magazine_id") Long magazineId);
}

