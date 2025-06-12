package com.tdd.interview.start

import com.tdd.ui.base.PageState

data class InterviewPageState (
    val interviews: List<String> = emptyList()
): PageState