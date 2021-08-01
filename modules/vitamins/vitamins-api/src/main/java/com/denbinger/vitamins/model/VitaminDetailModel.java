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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import org.osgi.annotation.versioning.ProviderType;

import java.util.Date;

/**
 * The base model interface for the VitaminDetail service. Represents a row in the &quot;FOO_VitaminDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.denbinger.vitamins.model.impl.VitaminDetailModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.denbinger.vitamins.model.impl.VitaminDetailImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetail
 * @generated
 */
@ProviderType
public interface VitaminDetailModel
	extends BaseModel<VitaminDetail>, GroupedModel, ShardedModel,
			StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vitamin detail model instance should use the {@link VitaminDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this vitamin detail.
	 *
	 * @return the primary key of this vitamin detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vitamin detail.
	 *
	 * @param primaryKey the primary key of this vitamin detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this vitamin detail.
	 *
	 * @return the uuid of this vitamin detail
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this vitamin detail.
	 *
	 * @param uuid the uuid of this vitamin detail
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the vitamin detail ID of this vitamin detail.
	 *
	 * @return the vitamin detail ID of this vitamin detail
	 */
	public long getVitaminDetailId();

	/**
	 * Sets the vitamin detail ID of this vitamin detail.
	 *
	 * @param vitaminDetailId the vitamin detail ID of this vitamin detail
	 */
	public void setVitaminDetailId(long vitaminDetailId);

	/**
	 * Returns the persisted vitamin ID of this vitamin detail.
	 *
	 * @return the persisted vitamin ID of this vitamin detail
	 */
	public long getPersistedVitaminId();

	/**
	 * Sets the persisted vitamin ID of this vitamin detail.
	 *
	 * @param persistedVitaminId the persisted vitamin ID of this vitamin detail
	 */
	public void setPersistedVitaminId(long persistedVitaminId);

	/**
	 * Returns the group ID of this vitamin detail.
	 *
	 * @return the group ID of this vitamin detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this vitamin detail.
	 *
	 * @param groupId the group ID of this vitamin detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this vitamin detail.
	 *
	 * @return the company ID of this vitamin detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this vitamin detail.
	 *
	 * @param companyId the company ID of this vitamin detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this vitamin detail.
	 *
	 * @return the user ID of this vitamin detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this vitamin detail.
	 *
	 * @param userId the user ID of this vitamin detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this vitamin detail.
	 *
	 * @return the user uuid of this vitamin detail
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this vitamin detail.
	 *
	 * @param userUuid the user uuid of this vitamin detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this vitamin detail.
	 *
	 * @return the user name of this vitamin detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this vitamin detail.
	 *
	 * @param userName the user name of this vitamin detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this vitamin detail.
	 *
	 * @return the create date of this vitamin detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this vitamin detail.
	 *
	 * @param createDate the create date of this vitamin detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this vitamin detail.
	 *
	 * @return the modified date of this vitamin detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this vitamin detail.
	 *
	 * @param modifiedDate the modified date of this vitamin detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the type of this vitamin detail.
	 *
	 * @return the type of this vitamin detail
	 */
	public int getType();

	/**
	 * Sets the type of this vitamin detail.
	 *
	 * @param type the type of this vitamin detail
	 */
	public void setType(int type);

	/**
	 * Returns the value of this vitamin detail.
	 *
	 * @return the value of this vitamin detail
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this vitamin detail.
	 *
	 * @param value the value of this vitamin detail
	 */
	public void setValue(String value);

}