package com.example.navigation_mvvm.navigation

import androidx.annotation.IdRes
import com.example.navigation_mvvm.R

sealed class RouteSection(@IdRes val graph: Int) {
    object Login : RouteSection(R.id.loginNavGraph)
    object Settings : RouteSection(R.id.settingsNavGraph)
}

sealed class RouteDestination(@IdRes val destination: Int) {

    object Back : RouteDestination(-1)

    sealed class Login(@IdRes destination: Int) : RouteDestination(destination) {

        object Credentials : Login(R.id.credentialsFragment)
        object TermsConditions : Login(R.id.termsConditionsFragment)
    }

    sealed class Settings(@IdRes destination: Int) : RouteDestination(destination) {

        object Profile : Settings(R.id.profileFragment)
        object Notifications : Settings(R.id.notificationsFragment)
    }
}