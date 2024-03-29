package com.denbinger.headless.vitamins.internal.util;

import com.denbinger.headless.vitamins.dto.v1_0.Creator;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;

public class CreatorUtil {
    public static Creator toCreator(Portal portal, User user) {
        if ((user == null) || user.isDefaultUser()) {
            return null;
        }

        return new Creator() {
            {
                additionalName = user.getMiddleName();
                familyName = user.getLastName();
                givenName = user.getFirstName();
                id = user.getUserId();
                name = user.getFullName();

                setImage(
                        () -> {
                            if (user.getPortraitId() == 0) {
                                return null;
                            }

                            ThemeDisplay themeDisplay = new ThemeDisplay() {
                                {
                                    setPathImage(portal.getPathImage());
                                }
                            };

                            return user.getPortraitURL(themeDisplay);
                        });
                setProfileURL(
                        () -> {
                            Group group = user.getGroup();

                            ThemeDisplay themeDisplay = new ThemeDisplay() {
                                {
                                    setPortalURL(StringPool.BLANK);
                                    setSiteGroupId(group.getGroupId());
                                }
                            };

                            return group.getDisplayURL(themeDisplay);
                        });
            }
        };
    }
}
