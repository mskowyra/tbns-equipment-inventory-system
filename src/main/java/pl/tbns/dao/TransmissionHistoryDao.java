package pl.tbns.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.tbns.model.TransmissionHistory;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 11:26:43 PM
 * 
 */
public interface TransmissionHistoryDao extends JpaRepository<TransmissionHistory, Long>{

	@Query(value="SELECT * "
			+ "FROM TransmissionHistory "
			+ "LEFT JOIN  equipment "
			+ "ON TransmissionHistory.equipment_id = Equipment.equipment_id "
			+ "LEFT JOIN User "
			+ "ON TransmissionHistory.sourceUser_id = User.id "
			+ "LEFT JOIN Magazine "
			+ "ON TransmissionHistory.sourceMagazine_id = Magazine.magazine_id "			
			+ "WHERE Magazine.magazine_id = :magazine_id ", nativeQuery=true )	
	public List<TransmissionHistory> findbyMagazine(@Param("magazine_id") Long magazineId);
}
