package com.dy.dao;


import org.springframework.stereotype.Repository;

import com.dy.basic.dao.BaseDao;
import com.dy.model.Attachment;
@Repository("attachmentDao")
public class AttachmentDao extends BaseDao<Attachment> implements IAttachmentDao {

	
}
