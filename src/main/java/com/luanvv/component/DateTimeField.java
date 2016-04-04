package com.luanvv.component;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;

public class DateTimeField extends TextField<String> {

	public DateTimeField(String id) {
		super(id);
	}
	public DateTimeField(final String id, final IModel<String> model){
		super(id, model);
	}
@Override
public void renderHead(IHeaderResponse response) {
	response.render(OnDomReadyHeaderItem.forScript(
			new StringBuilder("$('#"+getMarkupId()+"').datepicker();")
			.toString()
			));
}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
