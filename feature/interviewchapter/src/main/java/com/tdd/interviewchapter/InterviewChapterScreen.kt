package com.tdd.interviewchapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tdd.design_system.BackGround
import com.tdd.design_system.Black1
import com.tdd.design_system.BookShelfTypo
import com.tdd.design_system.InterviewChapterTitle
import com.tdd.ui.common.content.TopPageTitle
import com.tdd.ui.common.type.ChapterType

@Composable
fun InterviewChapterScreen() {

    val viewModel: InterviewChapterViewModel = hiltViewModel()
    val uiState: InterviewChapterPageState by viewModel.uiState.collectAsStateWithLifecycle()

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

        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally)
            ) {
                ChapterType.entries.take(4).forEach { chapter ->
                    InterviewChapterItem(
                        chapter = chapter
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),
                horizontalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterHorizontally)
            ) {
                ChapterType.entries.drop(4).forEach { chapter ->
                    InterviewChapterItem(
                        chapter = chapter
                    )
                }
            }
        }
    }
}

@Composable
fun InterviewChapterItem(
    chapter: ChapterType,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = chapter.chapterImg),
            contentDescription = "chapter",
            modifier = Modifier
                .size(width = 180.dp, height = 200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = chapter.chapterName,
            color = Black1,
            style = BookShelfTypo.body30
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInterviewChapter() {
    InterviewChapterContent()
}