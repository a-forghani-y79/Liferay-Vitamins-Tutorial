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

package com.denbinger.vitamins.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.denbinger.vitamins.service.http.VitaminDetailServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class VitaminDetailSoap implements Serializable {

	public static VitaminDetailSoap toSoapModel(VitaminDetail model) {
		VitaminDetailSoap soapModel = new VitaminDetailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setVitaminDetailId(model.getVitaminDetailId());
		soapModel.setPersistedVitaminId(model.getPersistedVitaminId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static VitaminDetailSoap[] toSoapModels(VitaminDetail[] models) {
		VitaminDetailSoap[] soapModels = new VitaminDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VitaminDetailSoap[][] toSoapModels(VitaminDetail[][] models) {
		VitaminDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VitaminDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VitaminDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VitaminDetailSoap[] toSoapModels(List<VitaminDetail> models) {
		List<VitaminDetailSoap> soapModels = new ArrayList<VitaminDetailSoap>(
			models.size());

		for (VitaminDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VitaminDetailSoap[soapModels.size()]);
	}

	public VitaminDetailSoap() {
	}

	public long getPrimaryKey() {
		return _vitaminDetailId;
	}

	public void setPrimaryKey(long pk) {
		setVitaminDetailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getVitaminDetailId() {
		return _vitaminDetailId;
	}

	public void setVitaminDetailId(long vitaminDetailId) {
		_vitaminDetailId = vitaminDetailId;
	}

	public long getPersistedVitaminId() {
		return _persistedVitaminId;
	}

	public void setPersistedVitaminId(long persistedVitaminId) {
		_persistedVitaminId = persistedVitaminId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _uuid;
	private long _vitaminDetailId;
	private long _persistedVitaminId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _type;
	private String _value;

}