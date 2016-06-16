/**
 * This file is part of mycollab-web.
 *
 * mycollab-web is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mycollab-web is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with mycollab-web.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.esofthead.mycollab.shell.view;

import com.esofthead.mycollab.common.i18n.ErrorI18nEnum;
import com.esofthead.mycollab.common.i18n.GenericI18Enum;
import com.esofthead.mycollab.common.i18n.ShellI18nEnum;
import com.esofthead.mycollab.core.utils.StringUtils;
import com.esofthead.mycollab.eventmanager.EventBusFactory;
import com.esofthead.mycollab.module.user.domain.User;
import com.esofthead.mycollab.module.user.service.UserService;
import com.esofthead.mycollab.shell.events.ShellEvent;
import com.esofthead.mycollab.spring.AppContextUtil;
import com.esofthead.mycollab.vaadin.AppContext;
import com.esofthead.mycollab.vaadin.mvp.AbstractPageView;
import com.esofthead.mycollab.vaadin.mvp.ViewComponent;
import com.esofthead.mycollab.vaadin.ui.NotificationUtil;
import com.esofthead.mycollab.vaadin.web.ui.UIConstants;
import com.esofthead.mycollab.web.CustomLayoutExt;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.TextField;

/**
 * @author MyCollab Ltd.
 * @since 1.0
 */
@ViewComponent
public class ForgotPasswordViewImpl extends AbstractPageView implements ForgotPasswordView {
    private static final long serialVersionUID = 1L;

    public ForgotPasswordViewImpl() {
        this.addComponent(new ForgotPwdForm());
    }

    private class ForgotPwdForm extends CustomComponent {
        private static final long serialVersionUID = 1L;
        private final TextField nameOrEmailField;

        ForgotPwdForm() {
            CustomLayout customLayout = CustomLayoutExt.createLayout("forgotPassword");
            customLayout.setStyleName("forgotPwdForm");

            nameOrEmailField = new TextField(AppContext.getMessage(ShellI18nEnum.FORM_EMAIL));
            customLayout.addComponent(nameOrEmailField, "nameoremail");

            Button sendEmail = new Button(AppContext.getMessage(ShellI18nEnum.BUTTON_RESET_PASSWORD), new ClickListener() {
                @Override
                public void buttonClick(ClickEvent clickEvent) {
                    String username = nameOrEmailField.getValue();
                    if (StringUtils.isValidEmail(username)) {
                        UserService userService = AppContextUtil.getSpringBean(UserService.class);
                        User user = userService.findUserByUserName(username);

                        if (user == null) {
                            NotificationUtil.showErrorNotification(AppContext.getMessage(GenericI18Enum.ERROR_USER_IS_NOT_EXISTED, username));
                        } else {
                            userService.requestToResetPassword(user.getUsername());
                            NotificationUtil.showNotification(AppContext.getMessage(GenericI18Enum.OPT_SUCCESS),
                                    AppContext.getMessage(ShellI18nEnum.OPT_EMAIL_SENDER_NOTIFICATION));
                            EventBusFactory.getInstance().post(new ShellEvent.LogOut(this, null));
                        }
                    } else {
                        NotificationUtil.showErrorNotification(AppContext.getMessage(ErrorI18nEnum.NOT_VALID_EMAIL, username));
                    }
                }
            });
            sendEmail.setStyleName(UIConstants.BUTTON_ACTION);
            customLayout.addComponent(sendEmail, "loginButton");

            Button memoBackBtn = new Button(AppContext.getMessage(ShellI18nEnum.BUTTON_IGNORE_RESET_PASSWORD), new ClickListener() {
                @Override
                public void buttonClick(ClickEvent clickEvent) {
                    EventBusFactory.getInstance().post(new ShellEvent.LogOut(this, null));
                }
            });
            memoBackBtn.setStyleName(UIConstants.BUTTON_LINK);
            customLayout.addComponent(memoBackBtn, "forgotLink");

            this.setCompositionRoot(customLayout);
        }
    }
}
