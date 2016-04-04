package com.luanvv.model;

import org.apache.wicket.model.IModel;

import com.luanvv.entity.User;

public class UserModel implements IModel<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public UserModel() {
		this(new User());
	}

	public UserModel(User user) {
		this.user = user;
	}

	@Override
	public void detach() {
		// không detach object do phải sử dụng ajax. Thử bỏ comment chạy thử
//		user = null;
	}

	@Override
	public User getObject() {
		if(user == null){
			user = new User();
		}
		return user;
	}

	@Override
	public void setObject(User object) {
		user = object;
	}

}
