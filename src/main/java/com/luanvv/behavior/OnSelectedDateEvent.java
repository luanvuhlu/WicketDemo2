package com.luanvv.behavior;

import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.util.string.StringValue;

import com.googlecode.wicket.jquery.core.JQueryAbstractBehavior;

public abstract class OnSelectedDateEvent extends AbstractDefaultAjaxBehavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void onBind() {
		super.onBind();
		getComponent().add(newBehavior());
	}
	@Override
	protected void respond(AjaxRequestTarget target) {
		StringValue dateText = RequestCycle.get().getRequest().getRequestParameters().getParameterValue(getComponent().getId());
		onSelected(target, dateText.toOptionalString());
	}
	protected abstract void onSelected(AjaxRequestTarget target, String dateText);
	
	private Behavior newBehavior(){
		return new JQueryAbstractBehavior() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected String $() {
				return new StringBuilder().append("$('#"+getComponent().getMarkupId()+"')")
						.append(".datepicker('option', 'onSelect', function(dateText, inst){")
						.append(getCallbackScript())
						.append("});").toString();
			}
		};
	}

}
