package com.tps.web.staroffice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tps.web.staroffice.customer.utils.StarUtil;
import com.tps.web.staroffice.dao.DocDao;
import com.tps.web.staroffice.dto.CommentsDto;
import com.tps.web.staroffice.dto.DocumentDto;
import com.tps.web.staroffice.dto.FilesDto;
import com.tps.web.staroffice.dto.SavedDocumentDto;
import com.tps.web.staroffice.entity.CommentsEntity;
import com.tps.web.staroffice.entity.DocumentEntity;
import com.tps.web.staroffice.entity.FilesEntity;
import com.tps.web.staroffice.entity.SavedDocumentEntity;
import com.tps.web.staroffice.service.DocService;

@Service
public class DocServiceImpl implements DocService {

	@Resource
	private DocDao dao;

	@Override
	public List<DocumentDto> getNewestDocumentsFromAllDepartmentsLimit5() {
		return this.dao.getNewestDocumentsFromAllDepartmentsLimit5();
	}
	@Override
	public List<DocumentDto> getNewestSavedDocumentsFromAllDepartmentsLimit5(DocumentDto documentDto) {
		return this.dao.getNewestSavedDocumentsFromAllDepartmentsLimit5(documentDto);
	}

	@Override
	public boolean deleteFiles(FilesDto filesDto) {
		FilesEntity filesEntity = new FilesEntity();
		BeanUtils.copyProperties(filesDto, filesEntity);
		return StarUtil.convertToBoolean(this.dao.deleteFiles(filesEntity));
	}
	@Override
	public boolean updateDocument(DocumentDto documentDto) {
		DocumentEntity documentEntity = new DocumentEntity();
		BeanUtils.copyProperties(documentDto, documentEntity);
		return StarUtil.convertToBoolean(this.dao.updateDocument(documentEntity));
	}
	@Override
	public boolean insertFiles(FilesDto filesDto) {
		FilesEntity filesEntity = new FilesEntity();
		BeanUtils.copyProperties(filesDto, filesEntity);
		return StarUtil.convertToBoolean(this.dao.insertFiles(filesEntity));
	}
	@Override
	public int getInsertedDocumentNumber(DocumentDto documentDto) {
		DocumentEntity documentEntity = new DocumentEntity();
		BeanUtils.copyProperties(documentDto, documentEntity);
		return this.dao.getInsertedDocumentNumber(documentEntity);
	}
	@Override
	public boolean insertDocument(DocumentDto documentDto) {
		DocumentEntity documentEntity = new DocumentEntity();
		BeanUtils.copyProperties(documentDto, documentEntity);
		return StarUtil.convertToBoolean(this.dao.insertDocument(documentEntity));
	}
	@Override
	public boolean insertComments(CommentsDto commentsDto) {
		CommentsEntity commentsEntity = new CommentsEntity();
		BeanUtils.copyProperties(commentsDto, commentsEntity);
		return StarUtil.convertToBoolean(this.dao.insertComments(commentsEntity));
	}
	@Override
	public boolean deleteComments(CommentsDto commentsDto) {
		CommentsEntity commentsEntity = new CommentsEntity();
		BeanUtils.copyProperties(commentsDto, commentsEntity);
		return StarUtil.convertToBoolean(this.dao.deleteComments(commentsEntity));
	}
	@Override
	public boolean updateComments(CommentsDto commentsDto) {
		CommentsEntity commentsEntity = new CommentsEntity();
		BeanUtils.copyProperties(commentsDto, commentsEntity);
		return StarUtil.convertToBoolean(this.dao.updateComments(commentsEntity));
	}

	@Override
	public boolean deleteDocument(DocumentDto documentDto) {
		DocumentEntity documentEntity = new DocumentEntity();
		BeanUtils.copyProperties(documentDto, documentEntity);
		return StarUtil.convertToBoolean(this.dao.deleteDocument(documentEntity));
	}
	@Override
	public boolean deleteSavedDocument(SavedDocumentDto savedDocumentDto) {
		SavedDocumentEntity savedDocumentEntity = new SavedDocumentEntity();
		BeanUtils.copyProperties(savedDocumentDto, savedDocumentEntity);
		return StarUtil.convertToBoolean(this.dao.deleteSavedDocument(savedDocumentEntity));
	}
	@Override
	public boolean insertSavedDocument(SavedDocumentDto savedDocumentDto) {
		SavedDocumentEntity savedDocumentEntity = new SavedDocumentEntity();
		BeanUtils.copyProperties(savedDocumentDto, savedDocumentEntity);
		return StarUtil.convertToBoolean(this.dao.insertSavedDocument(savedDocumentEntity));
	}
	@Override
	public boolean updateDocumentViewCount(DocumentDto documentDto) {
		DocumentEntity documentEntity = new DocumentEntity();
		BeanUtils.copyProperties(documentDto, documentEntity);
		return StarUtil.convertToBoolean(this.dao.updateDocumentViewCount(documentEntity));
	}
	@Override
	public DocumentDto getDocument(DocumentDto documentDto) {
		return this.dao.getDocument(documentDto);
	}

	@Override
	public int getDocumentsCount(DocumentDto documentDto) {
		return this.dao.getDocumentsCount(documentDto);
	}
	@Override
	public int getDocumentsCountFromAllDepartments(DocumentDto documentDto) {
		return this.dao.getDocumentsCountFromAllDepartments(documentDto);
	}
	@Override
	public int getSavedDocumentsCount(DocumentDto documentDto) {
		return this.dao.getSavedDocumentsCount(documentDto);
	}
	@Override
	public int getSavedDocumentsCountFromAllDepartments(DocumentDto documentDto) {
		return this.dao.getSavedDocumentsCountFromAllDepartments(documentDto);
	}


	public List<DocumentDto> getNewestDocuments(DocumentDto documentDto){
		return this.dao.getNewestDocuments(documentDto);
	}
	public List<DocumentDto> getNewestDocumentsFromAllDepartments(DocumentDto documentDto){
		return this.dao.getNewestDocumentsFromAllDepartments(documentDto);
	}
	public List<DocumentDto> getMostViewedDocuments(DocumentDto documentDto){
		return this.dao.getMostViewedDocuments(documentDto);
	}
	public List<DocumentDto> getMostViewedDocumentsFromAllDepartments(DocumentDto documentDto){
		return this.dao.getMostViewedDocumentsFromAllDepartments(documentDto);
	}


	public List<DocumentDto> getNewestSavedDocuments(DocumentDto documentDto){
		return this.dao.getNewestSavedDocuments(documentDto);
	}
	public List<DocumentDto> getNewestSavedDocumentsFromAllDepartments(DocumentDto documentDto){
		return this.dao.getNewestSavedDocumentsFromAllDepartments(documentDto);
	}
	public List<DocumentDto> getMostViewedSavedDocuments(DocumentDto documentDto){
		return this.dao.getMostViewedSavedDocuments(documentDto);
	}
	public List<DocumentDto> getMostViewedSavedDocumentsFromAllDepartments(DocumentDto documentDto){
		return this.dao.getMostViewedSavedDocumentsFromAllDepartments(documentDto);
	}
}