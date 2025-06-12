package com.tdd.interviewchapter

import com.tdd.domain.entity.response.interview.InterviewChapterModel
import com.tdd.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.tdd.design_system.R

@HiltViewModel
class InterviewChapterViewModel @Inject constructor(

): BaseViewModel<InterviewChapterPageState>(
    InterviewChapterPageState()
) {

    private fun initSetChapterList() {
        val chapters: List<InterviewChapterModel> = listOf(
            InterviewChapterModel(0, R.drawable.ic_chapter_one, "성장 과정"),
        )
    }
}