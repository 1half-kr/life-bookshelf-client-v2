package com.tdd.interviewchapter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tdd.design_system.BackGround
import com.tdd.design_system.InterviewChapterTitle
import com.tdd.ui.common.content.TopPageTitle

@Composable
fun InterviewChapterScreen() {
    InterviewChapterContent()
}

@Composable
fun InterviewChapterContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround),
    ) {
        TopPageTitle(
            title = InterviewChapterTitle
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInterviewChapter() {
    InterviewChapterContent()
}