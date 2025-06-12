package com.tdd.interview

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.tdd.design_system.BookShelfTypo
import com.tdd.design_system.InterviewTitle
import com.tdd.design_system.Main3
import com.tdd.design_system.R

@Composable
fun InterviewScreen() {

    val viewModel: InterviewViewModel = hiltViewModel()
    val uiState: InterviewPageState by viewModel.uiState.collectAsStateWithLifecycle()

    InterviewContent()
}

@Composable
fun InterviewContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                text = InterviewTitle,
                color = Main3,
                style = BookShelfTypo.head20,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(vertical = 50.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "home",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 50.dp)
                    .size(40.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewInterview() {
    InterviewContent()
}