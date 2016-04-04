package com.luanvv.base.page;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.PriorityHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.googlecode.wicket.jquery.ui.settings.JQueryUILibrarySettings;

import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.IeEdgeMetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MobileViewportMetaTag;

public class BasePage extends WebPage {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BasePage(IModel<?> model) {
		super(model);
	}
	
	public BasePage(final PageParameters parameters) {
		super(parameters);
	}
	public BasePage() {
		super();
	}
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new HtmlTag("html"));
      MobileViewportMetaTag mvt = new MobileViewportMetaTag("viewport");
      mvt.setWidth("device-width");
      mvt.setInitialScale("1");
      add(mvt);
      add(new IeEdgeMetaTag("ie-edge"));
      add(new MetaTag("description", Model.of("description"), Model.of("Apache Wicket Demo")));
      add(new MetaTag("author", Model.of("author"), Model.of("luanvv")));
	}
	@Override
	public void renderHead(IHeaderResponse response) {
		response.render(new PriorityHeaderItem(CssHeaderItem.forReference(JQueryUILibrarySettings.get().getStyleSheetReference())));
	}
}
