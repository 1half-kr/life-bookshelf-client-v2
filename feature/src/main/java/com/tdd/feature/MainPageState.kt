package com.tdd.feature

import com.tdd.ui.base.PageState
import com.tdd.ui.common.type.InterviewType

data class MainPageState (
    val interviewType: InterviewType = InterviewType.MIRROR
): PageState