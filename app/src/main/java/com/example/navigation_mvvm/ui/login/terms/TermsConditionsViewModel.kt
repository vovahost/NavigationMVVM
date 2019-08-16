package com.example.navigation_mvvm.ui.login.terms

import com.example.navigation_mvvm.navigation.RouteSection
import com.example.navigation_mvvm.ui.base.BaseViewModelImpl

class TermsConditionsViewModel : BaseViewModelImpl<TermsConditionsState>() {

    override val initialState = TermsConditionsState()

    fun onTermsAccepted() {
        // Save user choice
        navigateTo(RouteSection.Settings)
    }
}
