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

package com.denbinger.vitamins.service.http;

import com.denbinger.vitamins.service.VitaminDetailServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>VitaminDetailServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.denbinger.vitamins.model.VitaminDetailSoap</code>. If the method in the
 * service utility returns a
 * <code>com.denbinger.vitamins.model.VitaminDetail</code>, that is translated to a
 * <code>com.denbinger.vitamins.model.VitaminDetailSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class VitaminDetailServiceSoap {

	/**
	 * addVitaminDetail: Adds a new vitamin detail record.
	 *
	 * @param persistedVitaminId
	 * @param typeCode
	 * @param value
	 * @return VitaminDetail: The new instance.
	 */
	public static VitaminDetail addVitaminDetail(
			long persistedVitaminId, int typeCode, String value,
			ServiceContext serviceContext)
		throws RemoteException {

		try {
			VitaminDetail returnValue =
				VitaminDetailServiceUtil.addVitaminDetail(
					persistedVitaminId, typeCode, value, serviceContext);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * deleteAllVitaminDetails: Deletes all of the vitamin details.
	 *
	 * @param persistedVitaminId
	 */
	public static void deleteAllVitaminDetails(long persistedVitaminId)
		throws RemoteException {

		try {
			VitaminDetailServiceUtil.deleteAllVitaminDetails(
				persistedVitaminId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteVitaminDetailsByType(
			long persistedVitaminId, int typeCode)
		throws RemoteException {

		try {
			VitaminDetailServiceUtil.deleteVitaminDetailsByType(
				persistedVitaminId, typeCode);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static VitaminDetail deleteVitaminDetail(long vitaminDetailId)
		throws RemoteException {

		try {
			VitaminDetail returnValue =
				VitaminDetailServiceUtil.deleteVitaminDetail(vitaminDetailId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static VitaminDetail deleteVitaminDetail(VitaminDetail vitaminDetail)
		throws RemoteException {

		try {
			VitaminDetail returnValue =
				VitaminDetailServiceUtil.deleteVitaminDetail(vitaminDetail);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * getAllVitaminDetails: Returns the full list of details for the given persisted vitamin id.
	 *
	 * @param persistedVitaminId
	 * @return List The list of vitamin details.
	 */
	public static List<VitaminDetail> getAllVitaminDetails(
			long persistedVitaminId)
		throws RemoteException {

		try {
			List<VitaminDetail> returnValue =
				VitaminDetailServiceUtil.getAllVitaminDetails(
					persistedVitaminId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * getVitaminDetailsByType: Returns the list of details for the given persisted vitamin id and type.
	 *
	 * @param persistedVitaminId
	 * @param typeCode
	 * @return List The list of vitamin details.
	 */
	public static List<VitaminDetail> getVitaminDetailsByType(
			long persistedVitaminId, int typeCode)
		throws RemoteException {

		try {
			List<VitaminDetail> returnValue =
				VitaminDetailServiceUtil.getVitaminDetailsByType(
					persistedVitaminId, typeCode);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		VitaminDetailServiceSoap.class);

}