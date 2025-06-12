package com.tdd.onboarding.userage

import com.tdd.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserAgeViewModel @Inject constructor(

): BaseViewModel<UserAgePageState>(
    UserAgePageState()
) {

    fun setSelectedAge(age: String){
        updateState(
            uiState.value.copy(
                selectedUserAge = age
            )
        )
    }
}