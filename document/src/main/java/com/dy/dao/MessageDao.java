package com.dy.dao;


import org.springframework.stereotype.Repository;

import com.dy.basic.dao.BaseDao;
import com.dy.model.Message;
@Repository("messageDao")
public class MessageDao extends BaseDao<Message> implements IMessageDao {

	
}
