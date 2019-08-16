package com.example.navigation_mvvm.ui.base

import android.os.Bundle
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.navigation_mvvm.navigation.RouteDestination
import com.example.navigation_mvvm.navigation.RouteSection
import com.example.navigation_mvvm.navigation.defaultNavOptions
import com.example.navigation_mvvm.other.SingleEvent

abstract class BaseViewModelImpl<VS : BaseViewState> : ViewModel(), BaseViewModel<VS> {

    override val viewState: MediatorLiveData<VS> = MediatorLiveData()
    override val navigationEvent: MutableLiveData<SingleEvent<NavController.() -> Any>> = MutableLiveData()

    override var state: VS
        get() = viewState.value ?: initialState
        set(value) = viewState.setValue(value)  // Sets the value synchronously

    override var stateAsync: VS
        get() = state
        set(value) = viewState.postValue(value)  // Sets the value asynchronously

    override fun navigateTo(route: RouteSection, args: Bundle?) {
        withNavController { navigate(route.graph, args, defaultNavOptions) }
    }

    override fun navigateTo(route: RouteDestination, args: Bundle?, clearStack: Boolean) {
        when {
            route is RouteDestination.Back -> withNavController { popBackStack() }
            clearStack -> withNavController { popBackStack(route.destination, false) }
            else -> withNavController { navigate(route.destination, args, defaultNavOptions) }
        }
    }

    protected fun withNavController(block: NavController.() -> Any) {
        navigationEvent.postValue(SingleEvent(block))
    }
}