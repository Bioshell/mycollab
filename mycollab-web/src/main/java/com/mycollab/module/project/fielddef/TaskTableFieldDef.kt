/**
 * Copyright © MyCollab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mycollab.module.project.fielddef

import com.mycollab.common.TableViewField
import com.mycollab.common.i18n.GenericI18Enum
import com.mycollab.module.project.domain.Task
import com.mycollab.module.project.i18n.MilestoneI18nEnum
import com.mycollab.module.project.i18n.TaskI18nEnum
import com.mycollab.module.project.i18n.TimeTrackingI18nEnum
import com.mycollab.vaadin.web.ui.WebUIConstants

/**
 * @author MyCollab Ltd
 * @since 6.0.0
 */
object TaskTableFieldDef {
    @JvmField
    val id = TableViewField(null, "id", WebUIConstants.TABLE_CONTROL_WIDTH)

    @JvmField
    val taskname = TableViewField(GenericI18Enum.FORM_NAME, Task.Field.name.name, WebUIConstants.TABLE_X_LABEL_WIDTH)

    @JvmField
    val note = TableViewField(GenericI18Enum.FORM_DESCRIPTION, Task.Field.description.name, WebUIConstants.TABLE_EX_LABEL_WIDTH)

    @JvmField
    val originalEstimate = TableViewField(TaskI18nEnum.FORM_ORIGINAL_ESTIMATE, "originalestimate", WebUIConstants.TABLE_M_LABEL_WIDTH)

    @JvmField
    val remainEstimate = TableViewField(TaskI18nEnum.FORM_REMAIN_ESTIMATE, "remainestimate", WebUIConstants.TABLE_M_LABEL_WIDTH)

    @JvmField
    val isEstimate = TableViewField(TaskI18nEnum.FORM_IS_ESTIMATED, "isestimated", WebUIConstants.TABLE_M_LABEL_WIDTH)

    @JvmField
    val status = TableViewField(GenericI18Enum.FORM_STATUS, "status", WebUIConstants.TABLE_X_LABEL_WIDTH)

    @JvmField
    val priority = TableViewField(GenericI18Enum.FORM_PRIORITY, "priority", WebUIConstants.TABLE_M_LABEL_WIDTH)

    @JvmField
    val startdate = TableViewField(GenericI18Enum.FORM_START_DATE, Task.Field.startdate.name, WebUIConstants.TABLE_DATE_WIDTH)

    @JvmField
    val enddate = TableViewField(GenericI18Enum.FORM_END_DATE, Task.Field.enddate.name, WebUIConstants.TABLE_DATE_WIDTH)

    @JvmField
    val duedate = TableViewField(GenericI18Enum.FORM_DUE_DATE, Task.Field.duedate.name, WebUIConstants.TABLE_DATE_WIDTH)

    @JvmField
    val percentagecomplete = TableViewField(TaskI18nEnum.FORM_PERCENTAGE_COMPLETE, "percentagecomplete", WebUIConstants.TABLE_S_LABEL_WIDTH)

    @JvmField
    val logUser = TableViewField(TaskI18nEnum.FORM_LOG_BY, "logByFullName", WebUIConstants.TABLE_X_LABEL_WIDTH)

    @JvmField
    val assignee = TableViewField(GenericI18Enum.FORM_ASSIGNEE, "assignUserFullName", WebUIConstants.TABLE_X_LABEL_WIDTH)

    @JvmField
    val milestoneName = TableViewField(MilestoneI18nEnum.SINGLE, "milestoneName", WebUIConstants.TABLE_X_LABEL_WIDTH)

    @JvmField
    val billableHours = TableViewField(TimeTrackingI18nEnum.OPT_BILLABLE_HOURS, "billableHours", WebUIConstants.TABLE_M_LABEL_WIDTH)

    @JvmField
    val nonBillableHours = TableViewField(TimeTrackingI18nEnum.OPT_NON_BILLABLE_HOURS, "nonBillableHours", WebUIConstants.TABLE_M_LABEL_WIDTH)
}