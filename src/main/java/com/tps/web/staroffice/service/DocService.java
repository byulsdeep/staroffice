package com.tps.web.staroffice.service;

import java.util.List;

import com.tps.web.staroffice.dto.CommentsDto;
import com.tps.web.staroffice.dto.DocumentDto;
import com.tps.web.staroffice.dto.FilesDto;
import com.tps.web.staroffice.dto.SavedDocumentDto;
import com.tps.web.staroffice.entity.FilesEntity;

public interface DocService {

	public abstract List<DocumentDto> getNewestDocumentsFromAllDepartmentsLimit5();
	public abstract List<DocumentDto> getNewestSavedDocumentsFromAllDepartmentsLimit5(DocumentDto documentDto);

	public abstract boolean deleteFiles(FilesDto filesDto);
	public abstract boolean updateDocument(DocumentDto documentDto);
	public abstract boolean insertFiles(FilesDto filesDto);
	public abstract int getInsertedDocumentNumber(DocumentDto documentDto);
	public abstract boolean insertDocument(DocumentDto documentDto);

	public abstract boolean insertComments(CommentsDto commentsDto);
	public abstract boolean deleteComments(CommentsDto commentsDto);
	public abstract boolean updateComments(CommentsDto commentsDto);

	public abstract boolean deleteDocument(DocumentDto documentDto);
	public abstract boolean deleteSavedDocument(SavedDocumentDto savedDocumentDto);
	public abstract boolean insertSavedDocument(SavedDocumentDto savedDocumentDto);
	public abstract boolean updateDocumentViewCount(DocumentDto documentDto);
	public abstract DocumentDto getDocument(DocumentDto documentDto);

	public abstract int getDocumentsCount(DocumentDto documentDto);
	public abstract int getDocumentsCountFromAllDepartments(DocumentDto documentDto);
	public abstract int getSavedDocumentsCount(DocumentDto documentDto);
	public abstract int getSavedDocumentsCountFromAllDepartments(DocumentDto documentDto);

	public abstract List<DocumentDto> getNewestDocuments(DocumentDto documentDto);
	public abstract List<DocumentDto> getNewestDocumentsFromAllDepartments(DocumentDto documentDto);
	public abstract List<DocumentDto> getMostViewedDocuments(DocumentDto documentDto);
	public abstract List<DocumentDto> getMostViewedDocumentsFromAllDepartments(DocumentDto documentDto);

	public abstract List<DocumentDto> getNewestSavedDocuments(DocumentDto documentDto);
	public abstract List<DocumentDto> getNewestSavedDocumentsFromAllDepartments(DocumentDto documentDto);
	public abstract List<DocumentDto> getMostViewedSavedDocuments(DocumentDto documentDto);
	public abstract List<DocumentDto> getMostViewedSavedDocumentsFromAllDepartments(DocumentDto documentDto);
}
