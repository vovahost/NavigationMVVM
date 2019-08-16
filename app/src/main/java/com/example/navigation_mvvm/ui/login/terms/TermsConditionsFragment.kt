package com.example.navigation_mvvm.ui.login.terms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation_mvvm.R
import com.example.navigation_mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.terms_conditions_fragment.*

class TermsConditionsFragment : BaseFragment<TermsConditionsState, TermsConditionsViewModel>() {

    override val viewModel: TermsConditionsViewModel by lazyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.terms_conditions_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        termsAcceptedBtn.setOnClickListener { viewModel.onTermsAccepted() }
    }

    override fun onStateChange(state: TermsConditionsState) {
    }
}
