package com.example.navigation_mvvm.ui.settings.profile

import com.example.navigation_mvvm.R
import com.example.navigation_mvvm.navigation.RouteDestination
import com.example.navigation_mvvm.ui.base.BaseViewModelImpl

class ProfileViewModel : BaseViewModelImpl<ProfileState>() {

    override val initialState = ProfileState()

    fun onOpenNotificationSettingsClick() {
        // Instead of using the navigateTo() utility function we can directly access
        // the NavController in specific cases
        // navigateTo(RouteDestination.Settings.Notifications)
        withNavController { navigate(R.id.notificationsFragment) }
    }

    override fun onBackPressed() {
        // We disabled the back button in ProfileFragment (by overriding the onReturnToPreviousScreen)
        // We get notified of Back press events here always.

        // Performs some actions first and navigate back
        navigateTo(RouteDestination.Back)
    }
}