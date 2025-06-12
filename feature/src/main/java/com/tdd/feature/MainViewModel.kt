package com.tdd.feature

import com.tdd.domain.entity.request.CreateUserModel
import com.tdd.ui.base.BaseViewModel
import com.tdd.ui.base.PageState
import com.tdd.ui.common.type.InterviewType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): BaseViewModel<MainPageState>(
    MainPageState()
) {

    val userModel = MutableSharedFlow<CreateUserModel>(replay = 1)

    fun setInterviewType(type: InterviewType) {
        updateState(
            uiState.value.copy(
                interviewType = type
            )
        )

        Timber.d("[인터뷰] $type")
    }
}