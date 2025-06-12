package com.tdd.interviewchapter

import com.tdd.design_system.ChapterGrowth
import com.tdd.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InterviewChapterViewModel @Inject constructor(

): BaseViewModel<InterviewChapterPageState>(
    InterviewChapterPageState()
) {

    init {
        initSetChapterList()
    }

    private fun initSetChapterList() {
        // TODO 챕터 주제 서버통신
        val chapters: List<String> = listOf(ChapterGrowth)

        updateState(
            uiState.value.copy(
                chapterValidList = chapters
            )
        )
    }
}