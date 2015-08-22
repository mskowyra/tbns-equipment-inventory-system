package pl.tbns.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tbns.model.TransmissionHistory;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 11:26:43 PM
 * 
 */
public interface TransmissionHistoryDao extends JpaRepository<TransmissionHistory, Long>{

}
