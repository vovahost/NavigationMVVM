package com.example.navigation_mvvm.ui.base

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.navigation_mvvm.extensions.lifecycleAwareLazy
import com.example.navigation_mvvm.extensions.retrieveSharedViewModel
import com.example.navigation_mvvm.extensions.retrieveViewModel
import com.example.navigation_mvvm.other.SharedViewModelFactory

abstract class BaseFragment<VS : BaseViewState, VM : BaseViewModel<VS>> : Fragment(), LifecycleOwner {

    var viewModelFactory: ViewModelProvider.Factory = SharedViewModelFactory()

    protected abstract val viewModel: VM

    protected inline fun <reified VM : ViewModel> lazyViewModel(): Lazy<VM> =
        lifecycleAwareLazy(this) {
            retrieveViewModel<VM>(viewModelFactory)
        }

    protected inline fun <reified VM : ViewModel> lazySharedViewModel(): Lazy<VM> =
        lifecycleAwareLazy(this) {
            retrieveSharedViewModel<VM>(viewModelFactory)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    onBackPressed()
                }
            })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeState(::onStateChange)
        observeNavigationEvent()
    }

    private fun observeState(callback: (state: VS) -> Unit) {
        val observer = Observer<VS> { state -> callback.invoke(state) }
        viewModel.viewState.observe(viewLifecycleOwner, observer)
        observer.onChanged(viewModel.state)     // Deliver initial state because initial state was initialized when there wasn't an observer observing state live data.
    }

    /** Override this in subclasses to listen to state changes */
    protected abstract fun onStateChange(state: VS)

    private fun observeNavigationEvent() {
        viewModel.navigationEvent.observe(viewLifecycleOwner, Observer { navEvent ->
            val consume = navEvent?.consume()
            consume?.invoke(findNavController())
        })
    }

    protected fun onBackPressed() {
        viewModel.onBackPressed()
        onReturnToPreviousScreen()
    }

    protected open fun onReturnToPreviousScreen() {
        findNavController().popBackStack()
    }

    /** Clears all shared ViewModels stored in parent Fragment or Activity */
    protected fun clearViewModels() {
        parentFragment?.viewModelStore?.clear()
    }
}