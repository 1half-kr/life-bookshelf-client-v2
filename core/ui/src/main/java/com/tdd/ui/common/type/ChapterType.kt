package com.tdd.ui.common.type

import com.tdd.design_system.ChapterEducation
import com.tdd.design_system.ChapterEmotion
import com.tdd.design_system.ChapterExperience
import com.tdd.design_system.ChapterFamily
import com.tdd.design_system.ChapterGrowth
import com.tdd.design_system.ChapterJob
import com.tdd.design_system.ChapterPersonality
import com.tdd.design_system.ChapterSociety
import com.tdd.design_system.R

enum class ChapterType(
    val chapterId: Int,
    val chapterImg: Int,
    val chapterName: String
) {
    GROWTH(1, R.drawable.ic_chapter_one, ChapterGrowth),
    FAMILY(2, R.drawable.ic_chapter_one, ChapterFamily),
    EDUCATION(3, R.drawable.ic_chapter_one, ChapterEducation),
    JOB(4, R.drawable.ic_chapter_one, ChapterJob),
    CHARACTER(5, R.drawable.ic_chapter_one, ChapterPersonality),
    EXPERIENCE(6, R.drawable.ic_chapter_one, ChapterExperience),
    EMOTION(7, R.drawable.ic_chapter_one, ChapterEmotion),
    SOCIETY(8, R.drawable.ic_chapter_one, ChapterSociety);

    companion object {
        fun getChapterImg(chapterId: Int) =
            entries.firstOrNull{ it.chapterId == chapterId }?.chapterImg ?: 0
    }
}