package com.luanvv;

import org.apache.wicket.markup.html.IPackageResourceGuard;
import org.apache.wicket.markup.html.SecurePackageResourceGuard;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import com.googlecode.wicket.jquery.ui.settings.JQueryUILibrarySettings;
import com.luanvv.configure.CommonResourceReference;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.references.JQueryMigrateJavaScriptReference;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.SingleThemeProvider;
import de.agilecoders.wicket.themes.markup.html.bootstrap.BootstrapThemeTheme;
import de.agilecoders.wicket.webjars.WicketWebjars;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.luanvv.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();
		configureResourceBundles();
	}
	private void configureResourceBundles() {
		configureBootstrap();
		// Configure
		JQueryUILibrarySettings.get().setStyleSheetReference(new CssResourceReference(CommonResourceReference.class, "jquery-ui.min.css"));
		IPackageResourceGuard packageResourceGuard = getResourceSettings().getPackageResourceGuard();
		if (packageResourceGuard instanceof SecurePackageResourceGuard) {
			SecurePackageResourceGuard securePackageResourceGuard = (SecurePackageResourceGuard) packageResourceGuard;
			securePackageResourceGuard.addPattern("+*.woff2");
		}

		// resource
		getResourceBundles().addJavaScriptBundle(WicketApplication.class, "extras.js",
				(JavaScriptResourceReference) getJavaScriptLibrarySettings().getJQueryReference(),
				JQueryMigrateJavaScriptReference.instance(),
				(JavaScriptResourceReference) getJavaScriptLibrarySettings().getWicketEventReference(),
				(JavaScriptResourceReference) getJavaScriptLibrarySettings().getWicketAjaxReference(),
				(JavaScriptResourceReference) Bootstrap.getSettings().getJsResourceReference(),
				(JavaScriptResourceReference) JQueryUILibrarySettings.get().getJavaScriptReference());
	}
	private void configureBootstrap() {
		WicketWebjars.install(this);
		IBootstrapSettings settings = new BootstrapSettings()
				.setThemeProvider(new SingleThemeProvider(new BootstrapThemeTheme()))
				.setAutoAppendResources(true);
		Bootstrap.install(this, settings);
	}

}
