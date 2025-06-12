package com.tdd.interviewchapter

import com.tdd.domain.entity.response.interview.InterviewChapterItem
import com.tdd.domain.entity.response.interview.InterviewChapterModel
import com.tdd.domain.entity.response.interview.InterviewSubChapterItem
import com.tdd.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InterviewChapterViewModel @Inject constructor(

) : BaseViewModel<InterviewChapterPageState>(
    InterviewChapterPageState()
) {

    init {
        initSetChapterList()
    }

    private fun initSetChapterList() {
        // TODO 챕터 주제 서버통신
        val chapters = InterviewChapterModel(
            9,
            listOf(
                InterviewChapterItem(
                    1,
                    "1",
                    "성장 과정",
                    "이거는 성장 과정임",
                    listOf(
                        InterviewSubChapterItem(
                            9,
                            "1.1",
                            "출생",
                            "이건 출생"
                        ),
                        InterviewSubChapterItem(
                            10,
                            "1.2",
                            "유년기",
                            "이건 유년기"
                        ),
                        InterviewSubChapterItem(
                            11,
                            "1.3",
                            "몰라",
                            "이건 몰라"
                        )
                    )
                ),
                InterviewChapterItem(
                    2,
                    "2",
                    "가족 관계",
                    "이거는 가족 관계임",
                    listOf(
                        InterviewSubChapterItem(
                            12,
                            "2.1",
                            "부모님",
                            "이건 부모님"
                        ),
                    )
                ),
                InterviewChapterItem(
                    3,
                    "3",
                    "학창 시절",
                    "이거는 학창 시절임"
                ),
                InterviewChapterItem(
                    4,
                    "4",
                    "직업/진로",
                    "이거는 학창 시절임"
                ),
                InterviewChapterItem(
                    5,
                    "5",
                    "가치관/성격",
                    "이거는 학창 시절임"
                ),
                InterviewChapterItem(
                    6,
                    "6",
                    "인생 경험",
                    "이거는 학창 시절임"
                ),
                InterviewChapterItem(
                    7,
                    "7",
                    "감정/취향",
                    "이거는 학창 시절임"
                ),
                InterviewChapterItem(
                    8,
                    "8",
                    "사회/문화",
                    "이거는 학창 시절임"
                ),
            )
        )

        updateState(
            uiState.value.copy(
                chapterList = chapters,
                progressChapter = findProgressChapter(chapters.currentChapterId, chapters.chapters)
            )
        )
    }

    private fun findProgressChapter(currentSubId: Int, chapters: List<InterviewChapterItem>): InterviewChapterItem =
        chapters.firstOrNull { chapter -> chapter.subChapters.any { it.chapterId == currentSubId } } ?: InterviewChapterItem()
}