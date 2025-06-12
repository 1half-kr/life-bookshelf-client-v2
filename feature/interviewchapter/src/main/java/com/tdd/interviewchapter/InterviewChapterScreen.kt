package com.tdd.interviewchapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InterviewChapterContent() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
    ) {
        val itemSpacing = 40.dp
        val itemWidth = 160.dp

        val itemsPerRow = if (maxWidth < 600.dp) 2 else 4
        val totalSpacing = itemSpacing * (itemsPerRow - 1)
        val totalContentWidth = itemWidth * itemsPerRow + totalSpacing

        Column {
            TopPageTitle(title = InterviewChapterTitle)

            FlowRow(
                modifier = Modifier
                    .widthIn(max = totalContentWidth)
                    .align(Alignment.CenterHorizontally)
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(itemSpacing),
                verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically)
            ) {
                ChapterType.entries.forEach { chapter ->
                    InterviewChapterItem(
                        chapter = chapter,
                        modifier = Modifier.width(itemWidth)
                    )
                }
            }
        }
    }
}

@Composable
fun InterviewChapterItem(
    chapter: ChapterType,
    modifier: Modifier,
) {
    Column(
        modifier = modifier,
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