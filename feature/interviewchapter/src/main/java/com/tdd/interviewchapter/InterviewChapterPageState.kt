package com.tdd.interviewchapter

import com.tdd.ui.base.PageState

data class InterviewChapterPageState(
    val chapterValidList: List<String> = emptyList(),
) : PageState