package com.tps.web.staroffice.dao;

import java.util.List;

import com.tps.web.staroffice.dto.PartnerDto;
import com.tps.web.staroffice.entity.MessageEntity;

public interface MessengerDao {

	public abstract int insertMessage(MessageEntity messageEntity);
	public abstract int updateMessageRead(MessageEntity messageEntity);
	public abstract List<MessageEntity> getAllMessages(MessageEntity messageEntity);
	public abstract PartnerDto getMySelfAsPartnerInfo(String employeeId);
	public abstract PartnerDto getPartnerInfo(MessageEntity messageEntity);
	public abstract List<PartnerDto> getAllPartnersInfo(String employeeId);
}
