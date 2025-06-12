package com.tdd.interview.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tdd.design_system.BackGround
import com.tdd.design_system.InterviewTitle
import com.tdd.ui.common.content.TopPageTitle

@Composable
fun InterviewMainScreen() {
    InterviewMainContent()
}

@Composable
fun InterviewMainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround),
    ) {
        TopPageTitle(
            title = InterviewTitle
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInterviewMain() {
    InterviewMainContent()
}