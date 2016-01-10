package com.dy.dao;


import org.springframework.stereotype.Repository;

import com.dy.basic.dao.BaseDao;
import com.dy.model.User;
@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao {

	
}
