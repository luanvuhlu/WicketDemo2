package com.luanvv;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.validation.validator.StringValidator;

import com.luanvv.base.page.BasePage;
import com.luanvv.behavior.OnSelectedDateEvent;
import com.luanvv.behavior.PlaceHolderAttribute;
import com.luanvv.behavior.UpperCaseBehavior;
import com.luanvv.component.AjaxToggleButton;
import com.luanvv.component.DateTimeField;
import com.luanvv.component.PasswordTextField;
import com.luanvv.entity.User;
import com.luanvv.model.ReadOnlyModel;
import com.luanvv.model.UserModel;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;
	private boolean isEnableComponents;
	
	public HomePage(IModel<User> model) {
		super(model);
    }
	public HomePage() {
		this(new UserModel());
	}
	@Override
	protected void onInitialize() {
		super.onInitialize();
		isEnableComponents = true;
		Form<User> form = createForm("form");
		add(form);
		RequiredTextField<String> fullName = createFullName("fullName");
		EmailTextField email = createEmail("email");
		DateTimeField dateOfBirth = createDateOfBirth("dateOfBirth");
		PasswordTextField password = createPassword("password");
		AjaxLink<Void> ajaxLink = createDisableButton("disableButton", "LabelDisableButton");
		SubmitLink submitBtn = createSubmitBtn("submitBtn", form);
		AjaxToggleButton toggleBtn = createToggleBtn("toggleBtn");
		
		form.add(new FeedbackPanel("feedbackPanel"), fullName, email, dateOfBirth, password, submitBtn, ajaxLink, toggleBtn);
	}
	
	@SuppressWarnings("unchecked")
	private Form<User> createForm(String id){
		return new Form<User>(id, (IModel<User>) getDefaultModel()){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			protected void onSubmit() {
				HomePage.this.onSubmit();
			}
		};
	}
	
	private void onSubmit(){
		User user = (User) getDefaultModelObject();
		System.out.println(user.getPassword());
	}
	
	private RequiredTextField<String> createFullName(String id){
		RequiredTextField<String> fullName = new RequiredTextField<String>(id, new PropertyModel<String>(getDefaultModel(), "fullName")){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isEnabled() {
				return isEnableComponents;
			}
		};
		fullName
		.add(StringValidator.maximumLength(50))
		.add(new UpperCaseBehavior())
		.add(new PlaceHolderAttribute(new ReadOnlyModel<String>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return isEnableComponents ? "Full name....." : "Don't do anything";
			}
		}));
		return fullName;
	}
	private EmailTextField createEmail(String id){
		return new EmailTextField(id, new PropertyModel<String>(getDefaultModel(), "email")){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isEnabled() {
				return isEnableComponents;
			}
		};
	}
	private DateTimeField createDateOfBirth(String id){
		DateTimeField dateOfBirth = new DateTimeField(id, new PropertyModel<String>(getDefaultModel(), "dateOfBirth")){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isEnabled() {
				return isEnableComponents;
			}
		};
		dateOfBirth.add(new OnSelectedDateEvent(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSelected(AjaxRequestTarget target, String dateText) {
				System.out.println(dateText);
			}
		});
		return dateOfBirth;
	}
	private PasswordTextField createPassword(String id){
		return new PasswordTextField(id, new PropertyModel<String>(getDefaultModel(), "password")){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isEnabled() {
				return isEnableComponents;
			}
		};
	}
	private AjaxLink<Void> createDisableButton(String id, String labelId){
		AjaxLink<Void> ajaxLink = new AjaxLink<Void>(id) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				isEnableComponents = !isEnableComponents;
				target.add(getParent());
			}
		};
		ajaxLink.add(new Label(labelId, new ReadOnlyModel<String>(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return isEnableComponents ? "Disable" : "Enable";
			}
		}));
		return ajaxLink;
	}
	private SubmitLink createSubmitBtn(String id, Form<?> form){
		SubmitLink submitBtn = new SubmitLink("submitBtn", form);
		submitBtn.add(new AttributeModifier("class", new ReadOnlyModel<String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return isEnableComponents ? "btn btn-success" : "btn btn-danger";
			}
		}));
		return submitBtn;
	}
	private AjaxToggleButton createToggleBtn(String id){
		return new AjaxToggleButton(id) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void on(AjaxRequestTarget target) {
				target.appendJavaScript("console.log('On....');");
			}
			
			@Override
			protected void off(AjaxRequestTarget target) {
				target.appendJavaScript("console.log('Off....');");
			}
		};
	}
}
