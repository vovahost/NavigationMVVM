package com.example.navigation_mvvm.ui.login.credentials

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation_mvvm.R
import com.example.navigation_mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.credentials_fragment.*

class CredentialsFragment : BaseFragment<CredentialsState, CredentialsViewModel>() {

    override val viewModel: CredentialsViewModel by lazyViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.credentials_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        submitCredentialsBtn.setOnClickListener { viewModel.onCredentialsSubmitted() }
        continueBtn.setOnClickListener { viewModel.onContinueClick() }
    }

    override fun onStateChange(state: CredentialsState) {
        continueBtn.isEnabled = state.credentialsValidated
    }

    override fun onReturnToPreviousScreen() {
        viewModel.onAppExit()
        activity?.finish()
    }
}