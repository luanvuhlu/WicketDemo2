package com.luanvv.configure;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.request.resource.ResourceReference;

import com.googlecode.wicket.jquery.ui.settings.JQueryUILibrarySettings;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.themes.markup.html.bootstrap.BootstrapThemeThemeCssReference;

public class CommonResourceReference {
	private static CommonResourceReference INSTANCE = null;
	
	public static synchronized CommonResourceReference get()
	{
		if (CommonResourceReference.INSTANCE == null)
		{
			CommonResourceReference.INSTANCE = new CommonResourceReference();
		}

		return CommonResourceReference.INSTANCE;
	}
	private CommonResourceReference() {
	}
	public JavaScriptHeaderItem getJqueryJs() {
		return JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference());
	}

	public HeaderItem getBootstrapCss() {
		return CssHeaderItem.forReference(Bootstrap.getSettings().getCssResourceReference());
	}
	public HeaderItem getBootstrapThemeCss() {
		return CssHeaderItem.forReference(BootstrapThemeThemeCssReference.instance());
	}
	
	public HeaderItem getBootstrapJs() {
		return JavaScriptHeaderItem.forReference(Bootstrap.getSettings().getJsResourceReference());
	}
	
	public ResourceReference getJqueryUIJs() {
		return (JavaScriptResourceReference) JQueryUILibrarySettings.get().getJavaScriptReference();
	}
}
