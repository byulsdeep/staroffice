package com.tps.web.staroffice.service;

import java.util.List;

import com.tps.web.staroffice.dto.MessageDto;
import com.tps.web.staroffice.dto.PartnerDto;

public interface MessengerService {

	public abstract boolean insertMessage(MessageDto messageDto);
	public abstract boolean updateMessageRead(MessageDto messageDto);
	public abstract List<MessageDto> getAllMessages(MessageDto messageDto);
	public abstract PartnerDto getMySelfAsPartnerInfo(String employeeId);
	public abstract PartnerDto getPartnerInfo(MessageDto messageDto);
	public abstract List<PartnerDto> getAllPartnersInfo(String employeeId);

}
