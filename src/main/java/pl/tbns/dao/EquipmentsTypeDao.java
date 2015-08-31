package pl.tbns.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tbns.model.EquipmentsType;

/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 11:25:29 PM
 * public List<EquipmentsType> getAllEquipmentsLodaLazy();
 */
public interface EquipmentsTypeDao extends JpaRepository<EquipmentsType, Long>{
								
	public EquipmentsType getEquipmentsTypeLazyLoadById(Long id);
	
	
	
}
