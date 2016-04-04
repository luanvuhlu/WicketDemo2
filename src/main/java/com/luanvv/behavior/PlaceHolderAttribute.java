package com.luanvv.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.lang.Args;

public class PlaceHolderAttribute extends Behavior {
	private final IModel<String> model;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void onComponentTag(Component component, ComponentTag tag) {
		tag.put("placeholder", model.getObject());
		super.onComponentTag(component, tag);
	}
	public PlaceHolderAttribute(IModel<String> model){
		Args.notNull(model, "model");
		this.model = model;
	}
}
