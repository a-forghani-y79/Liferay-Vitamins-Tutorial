package com.denbinger.vitamins.internal.resource.v1_0;

import com.denbinger.vitamins.resource.v1_0.VitaminResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author jinos
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/vitamin.properties",
	scope = ServiceScope.PROTOTYPE, service = VitaminResource.class
)
public class VitaminResourceImpl extends BaseVitaminResourceImpl {
}