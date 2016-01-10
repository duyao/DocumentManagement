package com.dy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "user_doc")
public class UserDocument {
	private int id;
	private Document document;
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
	@Column(name = "doc_id")
	public Document getMessage() {
		return document;
	}

	public void setMessage(Document document) {
		this.document = document;
	}

	@ManyToOne
	@Column(name = "user_id")
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
