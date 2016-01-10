package com.dy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author dy
 * �û�˽�����Ӷ���
 *
 */
@Entity
@Table(name = "user_msg")
public class UserMessage {
	private int id;
	private Message message;
	private User user;
	private int type;
	private int isRead;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "msg_id")
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * ���ջ��Ƿ���
	 * @return
	 */
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * �Ƿ��Ѷ�
	 * @return
	 */
	public int getIsRead() {
		return isRead;
	}
	public void setIsRead(int isRead) {
		this.isRead = isRead;
	}
	

}
