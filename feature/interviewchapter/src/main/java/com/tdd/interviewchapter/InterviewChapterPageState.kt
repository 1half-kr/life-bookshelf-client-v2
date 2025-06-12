package com.tdd.interviewchapter

import com.tdd.domain.entity.response.interview.InterviewChapterItem
import com.tdd.domain.entity.response.interview.InterviewChapterModel
import com.tdd.ui.base.PageState

data class InterviewChapterPageState(
    val chapterList: InterviewChapterModel = InterviewChapterModel(),
    val progressChapter: InterviewChapterItem = InterviewChapterItem()
) : PageState