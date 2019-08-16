package com.example.navigation_mvvm.ui.login.credentials

import com.example.navigation_mvvm.navigation.RouteDestination
import com.example.navigation_mvvm.ui.base.BaseViewModelImpl

class CredentialsViewModel : BaseViewModelImpl<CredentialsState>() {

    override val initialState = CredentialsState()

    fun onCredentialsSubmitted() {
        // Validate credentials
        state = state.copy(credentialsValidated = true)
    }

    fun onContinueClick() {
        navigateTo(RouteDestination.Login.TermsConditions)
    }

    fun onAppExit() {
        // Track user leaving the app
    }
}