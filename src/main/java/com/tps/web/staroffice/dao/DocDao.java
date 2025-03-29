package com.tps.web.staroffice.dao;

import java.util.List;

import com.tps.web.staroffice.dto.DocumentDto;
import com.tps.web.staroffice.entity.CommentsEntity;
import com.tps.web.staroffice.entity.DocumentEntity;
import com.tps.web.staroffice.entity.FilesEntity;
import com.tps.web.staroffice.entity.SavedDocumentEntity;

public interface DocDao {

	public abstract List<DocumentDto> getNewestDocumentsFromAllDepartmentsLimit5();
	public abstract List<DocumentDto> getNewestSavedDocumentsFromAllDepartmentsLimit5(DocumentDto documentDto);

	public abstract int deleteFiles(FilesEntity filesEntity);
	public abstract int updateDocument(DocumentEntity documentEntity);
	public abstract int insertFiles(FilesEntity filesEntity);
	public abstract int getInsertedDocumentNumber(DocumentEntity documentEntity);
	public abstract int insertDocument(DocumentEntity documentEntity);

	public abstract int insertComments(CommentsEntity commentsEntity);
	public abstract int deleteComments(CommentsEntity commentsEntity);
	public abstract int updateComments(CommentsEntity commentsEntity);

	public abstract int deleteDocument(DocumentEntity documentEntity);
	public abstract int deleteSavedDocument(SavedDocumentEntity savedDocumentEntity);
	public abstract int insertSavedDocument(SavedDocumentEntity savedDocumentEntity);
	public abstract int updateDocumentViewCount(DocumentEntity documentEntity);
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
