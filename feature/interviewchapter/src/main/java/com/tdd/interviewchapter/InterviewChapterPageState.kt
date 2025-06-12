package com.tdd.interviewchapter

import com.tdd.domain.entity.response.interview.InterviewChapterModel
import com.tdd.ui.base.PageState

data class InterviewChapterPageState (
    val chapterList: List<InterviewChapterModel> = emptyList()
): PageState