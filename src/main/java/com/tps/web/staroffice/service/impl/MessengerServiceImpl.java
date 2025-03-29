package com.tps.web.staroffice.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tps.web.staroffice.customer.utils.StarUtil;
import com.tps.web.staroffice.dao.MessengerDao;
import com.tps.web.staroffice.dto.MessageDto;
import com.tps.web.staroffice.dto.PartnerDto;
import com.tps.web.staroffice.entity.MessageEntity;
import com.tps.web.staroffice.service.MessengerService;

@Service
public class MessengerServiceImpl implements MessengerService {

	@Resource
	private MessengerDao dao;

	@Override
	public boolean insertMessage(MessageDto messageDto) {
		MessageEntity messageEntity = new MessageEntity();
		BeanUtils.copyProperties(messageDto, messageEntity);
		return StarUtil.convertToBoolean(this.dao.insertMessage(messageEntity));
	}
	@Override
	public boolean updateMessageRead(MessageDto messageDto) {
		MessageEntity messageEntity = new MessageEntity();
		BeanUtils.copyProperties(messageDto, messageEntity);
		return StarUtil.convertToBoolean(this.dao.updateMessageRead(messageEntity));
	}
	@Override
	public List<MessageDto> getAllMessages(MessageDto messageDto) {
		MessageEntity messageEntity = new MessageEntity();
		BeanUtils.copyProperties(messageDto, messageEntity);
		List<MessageEntity> messageEntities = this.dao.getAllMessages(messageEntity);
		List<MessageDto> messageDtoes = new ArrayList<>();
		for (int i = 0; i < messageEntities.size(); i++) {
			messageDto = new MessageDto();
			BeanUtils.copyProperties(messageEntities.get(i), messageDto);
			messageDtoes.add(messageDto);
		}
		return messageDtoes;
	}
	@Override
	public PartnerDto getMySelfAsPartnerInfo(String employeeId) {
		return this.dao.getMySelfAsPartnerInfo(employeeId);
	}
	@Override
	public PartnerDto getPartnerInfo(MessageDto messageDto) {
		MessageEntity messageEntity = new MessageEntity();
		BeanUtils.copyProperties(messageDto, messageEntity);
		return this.dao.getPartnerInfo(messageEntity);
	}
	@Override
	public List<PartnerDto> getAllPartnersInfo(String employeeId) {
		return this.dao.getAllPartnersInfo(employeeId);
	}
}