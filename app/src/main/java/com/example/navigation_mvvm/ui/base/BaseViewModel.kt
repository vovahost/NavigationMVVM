package com.example.navigation_mvvm.ui.base

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import com.example.navigation_mvvm.navigation.RouteDestination
import com.example.navigation_mvvm.navigation.RouteSection
import com.example.navigation_mvvm.other.SingleEvent

interface BaseViewModel<VS : BaseViewState> {

    val initialState: VS
    val viewState: MutableLiveData<VS>
    val navigationEvent: MutableLiveData<SingleEvent<NavController.() -> Any>>
    var state: VS
    var stateAsync: VS

    fun navigateTo(route: RouteSection, args: Bundle? = null)
    fun navigateTo(route: RouteDestination, args: Bundle? = null, clearStack: Boolean = false)
    fun onBackPressed() {}
}