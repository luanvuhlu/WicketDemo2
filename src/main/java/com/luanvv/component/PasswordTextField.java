package com.luanvv.component;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.core.JQueryAbstractBehavior;

public class PasswordTextField extends FormComponentPanel<String> {

	private org.apache.wicket.markup.html.form.PasswordTextField passwordField;
	
	public PasswordTextField(String id, IModel<String> model) {
		super(id, model);
		setType(String.class);
		setRenderBodyOnly(true);
		setOutputMarkupId(false);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		passwordField = newPasswordField("password", getModel());
		add(passwordField);
		add(newShowPasswordBehavior());
	}

	protected org.apache.wicket.markup.html.form.PasswordTextField newPasswordField(String id, IModel<String> model) {
		org.apache.wicket.markup.html.form.PasswordTextField field = new org.apache.wicket.markup.html.form.PasswordTextField(id, model);
		field.setOutputMarkupId(true);
		return field;
	}

	@Override
	public void convertInput() {
		setConvertedInput(passwordField.getConvertedInput());
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		checkComponentTag(tag, "input");
		checkComponentTagAttribute(tag, "type", new String[] { "password" });
		super.onComponentTag(tag);
	}
	protected Behavior newShowPasswordBehavior() {
		return new JQueryAbstractBehavior() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			protected String $() {
				return new StringBuilder("$('#"+passwordField.getMarkupId()+"+span').")
						.append("click(function(){")
						.append("var $pswd = $('#"+passwordField.getMarkupId()+"');")
						.append("if($pswd.attr('type') === 'password'){")
						.append("	$pswd.attr('type', 'text');")
						.append("}else{")
						.append("	$pswd.attr('type', 'password');")
						.append("}")
						.append("});").toString();
			}
		};
	}
	@Override
	public String getInputName() {
		return getId();
	}
}
