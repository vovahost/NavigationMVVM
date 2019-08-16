package com.example.navigation_mvvm.ui.settings.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation_mvvm.R
import com.example.navigation_mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.notifications_fragment.*

class NotificationsFragment : BaseFragment<NotificationsState, NotificationsViewModel>() {

    override val viewModel: NotificationsViewModel by lazyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notifications_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        returnToSettingsBtn.setOnClickListener {
            viewModel.onReturnToSettingsClick()
        }
    }

    override fun onStateChange(state: NotificationsState) {
    }
}