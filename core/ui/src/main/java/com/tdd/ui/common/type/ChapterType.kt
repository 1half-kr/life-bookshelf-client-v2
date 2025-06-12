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
    GROWTH(0, R.drawable.ic_chapter_one, ChapterGrowth),
    FAMILY(1, R.drawable.ic_chapter_one, ChapterFamily),
    EDUCATION(2, R.drawable.ic_chapter_one, ChapterEducation),
    JOB(3, R.drawable.ic_chapter_one, ChapterJob),
    CHARACTER(4, R.drawable.ic_chapter_one, ChapterPersonality),
    EXPERIENCE(5, R.drawable.ic_chapter_one, ChapterExperience),
    EMOTION(6, R.drawable.ic_chapter_one, ChapterEmotion),
    SOCIETY(7, R.drawable.ic_chapter_one, ChapterSociety);

    companion object {
//        fun getChapter(navType: BottomNavType): String =
//            entries.firstOrNull { it == navType }?.destination ?: ""
    }
}