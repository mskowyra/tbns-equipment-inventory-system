package pl.tbns.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.tbns.model.Magazine;


/**
 * @author Maciej Skowyra & Szymon Iwanski	
 * @date Aug 22, 2015 11:21:42 PM
 * 
 */
public interface MagazineDao extends JpaRepository<Magazine, Long> {

}
