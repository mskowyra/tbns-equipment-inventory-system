/**
 * 
 */
package pl.tbns.service;

import pl.tbns.model.TransmissionHistory;

/**
 * @author Maciej Skowyra
 * @author Szymon Iwański
 *
 */
public interface TransmissionHistoryService {

	public TransmissionHistory getTransmissionHistoryById(Long id);
	public void createTransmissionHistory(TransmissionHistory transmissionHistory, Long equipmentId, Long sourceMagazineId, Long destMagazineId);
	public void changeStatusTransmissionHistory(Long id, boolean status);
	public void modifyTransmissionHistory(TransmissionHistory transmissionHistory, Long equipmentId, Long sourceMagazineId, Long destMagazineId);
	public void deleteTransmissionHistoryById(Long id);
	public TransmissionHistory findTransmissionHistoryById(Long id);
}
