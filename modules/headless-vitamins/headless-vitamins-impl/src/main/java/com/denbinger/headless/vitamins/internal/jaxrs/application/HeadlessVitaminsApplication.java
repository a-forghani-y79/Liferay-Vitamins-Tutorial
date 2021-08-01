package com.denbinger.headless.vitamins.internal.jaxrs.application;

import org.osgi.service.component.annotations.Component;

import javax.annotation.Generated;
import javax.ws.rs.core.Application;

/**
 * @author jinos
 * @generated
 */
@Component(
	property = {
		"liferay.jackson=false",
		"osgi.jaxrs.application.base=/headless-vitamins",
		"osgi.jaxrs.extension.select=(osgi.jaxrs.name=Liferay.Vulcan)",
		"osgi.jaxrs.name=HeadlessVitamins"
	},
	service = Application.class
)
@Generated("")
public class HeadlessVitaminsApplication extends Application {
}