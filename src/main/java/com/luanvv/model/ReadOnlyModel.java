package com.luanvv.model;

import org.apache.wicket.model.IModel;

public abstract class ReadOnlyModel<T> implements IModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void detach() {
		
	}
	@Override
	public void setObject(T object) {
	}
}
