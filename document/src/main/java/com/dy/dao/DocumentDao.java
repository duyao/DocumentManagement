package com.dy.dao;


import org.springframework.stereotype.Repository;

import com.dy.basic.dao.BaseDao;
import com.dy.model.Document;
@Repository("documentDao")
public class DocumentDao extends BaseDao<Document> implements IDocumentDao {

	
}
