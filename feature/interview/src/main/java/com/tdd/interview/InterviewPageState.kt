package com.tdd.interview

import com.tdd.ui.base.PageState

data class InterviewPageState (
    val interviews: List<String> = emptyList()
): PageState