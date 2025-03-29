package com.tps.web.staroffice.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tps.web.staroffice.dao.DocDao;
import com.tps.web.staroffice.dto.CommentsDto;
import com.tps.web.staroffice.dto.DocumentDto;
import com.tps.web.staroffice.entity.CommentsEntity;
import com.tps.web.staroffice.entity.DocumentEntity;
import com.tps.web.staroffice.entity.FilesEntity;
import com.tps.web.staroffice.entity.SavedDocumentEntity;

public class DocDaoImpl extends SqlSessionDaoSupport implements DocDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List<DocumentDto> getNewestDocumentsFromAllDepartmentsLimit5() {
		return this.sqlSession.selectList("getNewestDocumentsFromAllDepartmentsLimit5");
	}
	@Override
	public List<DocumentDto> getNewestSavedDocumentsFromAllDepartmentsLimit5(DocumentDto documentDto) {
		return this.sqlSession.selectList("getNewestSavedDocumentsFromAllDepartmentsLimit5", documentDto);
	}

	@Override
	public int deleteFiles(FilesEntity filesEntity) {
		return this.sqlSession.delete("deleteFiles", filesEntity);
	}
	@Override
	public int updateDocument(DocumentEntity documentEntity) {
		return this.sqlSession.update("updateDocument", documentEntity);
	}
	@Override
	public int insertFiles(FilesEntity filesEntity) {
		return this.sqlSession.insert("insertFiles", filesEntity);
	}
	@Override
	public int getInsertedDocumentNumber(DocumentEntity documentEntity) {
		return this.sqlSession.selectOne("getInsertedDocumentNumber", documentEntity);
	}
	@Override
	public int insertDocument(DocumentEntity documentEntity) {
		return this.sqlSession.insert("insertDocument", documentEntity);
	}

	@Override
	public int insertComments(CommentsEntity commentsEntity) {
		return this.sqlSession.insert("insertComments", commentsEntity);
	}
	@Override
	public int deleteComments(CommentsEntity commentsEntity) {
		return this.sqlSession.delete("deleteComments", commentsEntity);
	}
	@Override
	public int updateComments(CommentsEntity commentsEntity) {
		return this.sqlSession.update("updateComments", commentsEntity);
	}

	@Override
	public int deleteDocument(DocumentEntity documentEntity) {
		return this.sqlSession.delete("deleteDocument",documentEntity);
	}
	@Override
	public int deleteSavedDocument(SavedDocumentEntity savedDocumentEntity) {
		return this.sqlSession.delete("deleteSavedDocument", savedDocumentEntity);
	}
	@Override
	public int insertSavedDocument(SavedDocumentEntity savedDocumentEntity) {
		return this.sqlSession.insert("insertSavedDocument", savedDocumentEntity);
	}
	@Override
	public int updateDocumentViewCount(DocumentEntity documentEntity) {
		return this.sqlSession.update("updateDocumentViewCount", documentEntity);
	}
	@Override
	public DocumentDto getDocument(DocumentDto documentDto) {
		return this.sqlSession.selectOne("getDocument", documentDto);
	}

	@Override
	public int getDocumentsCount(DocumentDto documentDto) {
		return this.sqlSession.selectOne("getDocumentsCount", documentDto);
	}
	@Override
	public int getDocumentsCountFromAllDepartments(DocumentDto documentDto) {
		return this.sqlSession.selectOne("getDocumentsCountFromAllDepartments", documentDto);
	}
	@Override
	public int getSavedDocumentsCount(DocumentDto documentDto) {
		return this.sqlSession.selectOne("getSavedDocumentsCount", documentDto);
	}
	@Override
	public int getSavedDocumentsCountFromAllDepartments(DocumentDto documentDto) {
		return this.sqlSession.selectOne("getSavedDocumentsCountFromAllDepartments", documentDto);
	}


	@Override
	public List<DocumentDto> getNewestDocuments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getNewestDocuments", documentDto);
	}
	@Override
	public List<DocumentDto> getNewestDocumentsFromAllDepartments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getNewestDocumentsFromAllDepartments", documentDto);
	}
	@Override
	public List<DocumentDto> getMostViewedDocuments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getMostViewedDocuments", documentDto);
	}
	@Override
	public List<DocumentDto> getMostViewedDocumentsFromAllDepartments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getMostViewedDocumentsFromAllDepartments", documentDto);
	}


	@Override
	public List<DocumentDto> getNewestSavedDocuments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getNewestSavedDocuments", documentDto);
	}
	@Override
	public List<DocumentDto> getNewestSavedDocumentsFromAllDepartments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getNewestSavedDocumentsFromAllDepartments", documentDto);
	}
	@Override
	public List<DocumentDto> getMostViewedSavedDocuments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getMostViewedSavedDocuments", documentDto);
	}
	@Override
	public List<DocumentDto> getMostViewedSavedDocumentsFromAllDepartments(DocumentDto documentDto) {
		return this.sqlSession.selectList("getMostViewedSavedDocumentsFromAllDepartments", documentDto);
	}
}