package com.tdd.interviewchapter

import com.tdd.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InterviewChapterViewModel @Inject constructor(

): BaseViewModel<InterviewChapterPageState>(
    InterviewChapterPageState()
) {
}