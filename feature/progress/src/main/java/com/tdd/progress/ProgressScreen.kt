package com.tdd.progress

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.tdd.design_system.BackGround
import com.tdd.design_system.Black1
import com.tdd.design_system.BookShelfTypo
import com.tdd.design_system.Gray3
import com.tdd.design_system.Gray4
import com.tdd.design_system.Gray5
import com.tdd.design_system.Main3
import com.tdd.design_system.ProgressBookEmptyBtn
import com.tdd.design_system.ProgressBookEmptySemiTitle
import com.tdd.design_system.ProgressBookEmptyTitle
import com.tdd.design_system.ProgressBookTitle
import com.tdd.design_system.ProgressStepNumber
import com.tdd.design_system.ProgressStepTitle
import com.tdd.design_system.ProgressTitle
import com.tdd.design_system.R
import com.tdd.design_system.White2
import com.tdd.design_system.White4
import com.tdd.domain.entity.response.progress.ProgressStepItem
import com.tdd.ui.common.button.BottomRectangleBtn
import com.tdd.ui.common.content.TopPageTitle

@Composable
fun ProgressScreen() {

    val viewModel: ProgressViewModel = hiltViewModel()
    val uiState: ProgressPageState by viewModel.uiState.collectAsStateWithLifecycle()

    ProgressContent(
        steps = uiState.progressStep
    )
}

@Composable
fun ProgressContent(
    steps: List<ProgressStepItem> = emptyList(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround),
    ) {
        TopPageTitle(
            title = ProgressTitle
        )

        ProgressStepList(
            steps = steps
        )

        ProgressBookList(
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ProgressStepList(
    steps: List<ProgressStepItem>,
) {
    Text(
        text = ProgressStepTitle,
        color = Black1,
        style = BookShelfTypo.body30,
        modifier = Modifier
            .padding(start = 50.dp)
    )

    LazyRow(
        modifier = Modifier
            .padding(top = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        contentPadding = PaddingValues(horizontal = 50.dp),
    ) {
        items(steps) { step ->
            ProgressStepItemContent(
                step = step
            )
        }
    }
}

@Composable
fun ProgressStepItemContent(
    step: ProgressStepItem,
) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (step.isProgress) Main3 else White2)
            .border(1.dp, Gray4, RoundedCornerShape(8.dp)),
    ) {
        Row(
            modifier = Modifier
                .padding(top = 15.dp, start = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (step.isFinish) {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "check",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(if (step.isProgress) Main3 else White2)
                        .border(1.dp, Gray3, CircleShape)
                ) {
                    Text(
                        text = String.format(ProgressStepNumber, step.step),
                        color = if (step.isProgress) White4 else Gray4,
                        style = BookShelfTypo.body60,
                        modifier = Modifier
                            .align(Alignment.Center)
                    )
                }
            }

            Text(
                text = step.title,
                style = BookShelfTypo.body50,
                color = if (step.isFinish) Black1 else if (step.isProgress) White4 else Gray5,
                modifier = Modifier
                    .padding(start = 10.dp)
            )
        }

        Text(
            text = step.content,
            style = BookShelfTypo.caption40,
            color = if (step.isProgress) White4 else Gray4,
            modifier = Modifier
                .padding(start = 60.dp, end = 20.dp, top = 10.dp, bottom = 20.dp)
        )
    }
}

@Composable
fun ProgressBookList(
    modifier: Modifier,
) {
    Text(
        text = ProgressBookTitle,
        color = Black1,
        style = BookShelfTypo.body30,
        modifier = Modifier
            .padding(top = 40.dp, start = 50.dp)
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp, vertical = 30.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(White2)
            .border(1.dp, Gray3, RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = ProgressBookEmptyTitle,
                color = Black1,
                style = BookShelfTypo.head30,
                textAlign = TextAlign.Center,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = ProgressBookEmptySemiTitle,
                color = Black1,
                style = BookShelfTypo.body30,
                textAlign = TextAlign.Center,
            )
        }

        BottomRectangleBtn(
            btnTextContent = ProgressBookEmptyBtn,
            isBtnActivated = true,
            onClickAction = {}
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewProgress() {
    ProgressContent()
}