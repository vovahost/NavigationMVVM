package com.example.navigation_mvvm.other

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.navigation_mvvm.ui.login.credentials.CredentialsViewModel
import com.example.navigation_mvvm.ui.login.terms.TermsConditionsViewModel
import com.example.navigation_mvvm.ui.settings.notifications.NotificationsViewModel
import com.example.navigation_mvvm.ui.settings.profile.ProfileViewModel

class SharedViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass) {
            CredentialsViewModel::class.java -> CredentialsViewModel() as T
            TermsConditionsViewModel::class.java -> TermsConditionsViewModel() as T
            NotificationsViewModel::class.java -> NotificationsViewModel() as T
            ProfileViewModel::class.java -> ProfileViewModel() as T
            else -> throw IllegalAccessException(modelClass.name)
        }
    }
}