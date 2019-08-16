package com.example.navigation_mvvm.ui.settings.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation_mvvm.R
import com.example.navigation_mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : BaseFragment<ProfileState, ProfileViewModel>() {

    override val viewModel: ProfileViewModel by lazyViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openNotificationsSettingsBtn.setOnClickListener {
            viewModel.onOpenNotificationSettingsClick()
        }
    }

    override fun onReturnToPreviousScreen() {
        // Override and do nothing. Disables Back button in Profile
    }

    override fun onStateChange(state: ProfileState) {
    }
}