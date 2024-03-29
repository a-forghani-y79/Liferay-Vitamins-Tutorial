/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.denbinger.vitamins.service;

import com.denbinger.vitamins.model.PersistedVitamin;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import org.osgi.annotation.versioning.ProviderType;

import java.util.List;

/**
 * Provides the remote service interface for PersistedVitamin. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedVitaminServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedVitaminService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.denbinger.vitamins.service.impl.PersistedVitaminServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the persisted vitamin remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PersistedVitaminServiceUtil} if injection and service tracking are not available.
	 */
	public PersistedVitamin addPersistedVitamin(
			String id, String name, String groupName, String description,
			int typeCode, String articleId, String[] chemicalNames,
			String[] properties, String[] attributes, String[] symptoms,
			String[] risks, ServiceContext serviceContext)
		throws PortalException;

	public void deletePersistedVitamin(String surrogateId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedVitamin> getAll();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedVitamin getPersistedVitamin(long persistedVitaminId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedVitamin getPersistedVitamin(String surrogateId)
		throws PortalException;

	public PersistedVitamin patchPersistedVitamin(
			String oldId, String id, String name, String groupName,
			String description, int typeCode, String articleId,
			String[] chemicalNames, String[] properties, String[] attributes,
			String[] symptoms, String[] risks, ServiceContext serviceContext)
		throws PortalException;

	public PersistedVitamin updatePersistedVitamin(
			String oldId, String id, String name, String groupName,
			String description, int typeCode, String articleId,
			String[] chemicalNames, String[] properties, String[] attributes,
			String[] symptoms, String[] risks, ServiceContext serviceContext)
		throws PortalException;

}