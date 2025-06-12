package com.tdd.feature

import com.tdd.domain.entity.request.CreateUserModel
import com.tdd.ui.base.BaseViewModel
import com.tdd.ui.base.PageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): BaseViewModel<PageState.Default>(PageState.Default) {

    val userModel = MutableSharedFlow<CreateUserModel>(replay = 1)
}