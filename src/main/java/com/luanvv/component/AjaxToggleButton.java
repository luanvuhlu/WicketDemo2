package com.luanvv.component;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;

import com.luanvv.model.ReadOnlyModel;

public abstract class AjaxToggleButton extends WebMarkupContainer {

	private static final String TURN_ON = "Turn on";
	private static final String TURN_OFF = "Turn off";
	private boolean on;
	public AjaxToggleButton(String id) {
		super(id);
	}
	
	@Override
	protected void onComponentTag(final ComponentTag tag) {
		checkComponentTag(tag, "input");
		checkComponentTagAttribute(tag, "type", new String[] { "button" });
		super.onComponentTag(tag);
		try {
			tag.put("value", on ? TURN_OFF : TURN_ON);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeModifier("class", new ReadOnlyModel<String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return on ? getOnCssClass() : getOffCssClass();
			}
		}));
		add(new AjaxEventBehavior("click") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onEvent(AjaxRequestTarget target) {
				if (on) {
					off(target);
				} else {
					on(target);
				}
				on = !on;
				target.add(getComponent());
			}

		});
	}
	protected abstract void on(AjaxRequestTarget target);

	protected abstract void off(AjaxRequestTarget target);

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String getOnCssClass() {
		return "btn btn-success";
	}
	protected String getOffCssClass() {
		return "btn btn-danger";
	}
}
