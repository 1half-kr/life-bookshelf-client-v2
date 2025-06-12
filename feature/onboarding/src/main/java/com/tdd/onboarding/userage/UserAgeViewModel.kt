package com.tdd.onboarding.userage

import com.tdd.domain.entity.request.CreateUserModel
import com.tdd.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserAgeViewModel @Inject constructor(

) : BaseViewModel<UserAgePageState>(
    UserAgePageState()
) {

    fun updateUserModel() = uiState.value.userModel.copy(age = uiState.value.selectedUserAge)

    fun setSelectedAge(age: String) {
        updateState(
            uiState.value.copy(
                selectedUserAge = age
            )
        )
    }
}