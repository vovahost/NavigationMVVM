package com.example.navigation_mvvm.ui.settings.notifications

import com.example.navigation_mvvm.ui.base.BaseViewModelImpl
import com.example.navigation_mvvm.navigation.RouteDestination

class NotificationsViewModel : BaseViewModelImpl<NotificationsState>() {

    override val initialState = NotificationsState()

    fun onReturnToSettingsClick() {
        navigateTo(RouteDestination.Back)
    }
}
