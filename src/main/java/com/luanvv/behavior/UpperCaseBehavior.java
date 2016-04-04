package com.luanvv.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;

public class UpperCaseBehavior extends Behavior {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		response.render(OnDomReadyHeaderItem.forScript(
				new StringBuilder()
				.append("$('#"+component.getMarkupId()+"').focusout(function(){")
				.append("$(this).val(this.value.toUpperCase());")
				.append("});")
				.toString()
				));
	}
}
