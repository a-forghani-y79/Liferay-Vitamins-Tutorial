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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the VitaminDetail service. Represents a row in the &quot;FOO_VitaminDetail&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VitaminDetailModel
 * @generated
 */
@ImplementationClassName("com.denbinger.vitamins.model.impl.VitaminDetailImpl")
@ProviderType
public interface VitaminDetail extends PersistedModel, VitaminDetailModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.denbinger.vitamins.model.impl.VitaminDetailImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<VitaminDetail, Long>
		VITAMIN_DETAIL_ID_ACCESSOR = new Accessor<VitaminDetail, Long>() {

			@Override
			public Long get(VitaminDetail vitaminDetail) {
				return vitaminDetail.getVitaminDetailId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<VitaminDetail> getTypeClass() {
				return VitaminDetail.class;
			}

		};

}