package com.tdd.ui.common.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tdd.design_system.BackGround
import com.tdd.design_system.Black1
import com.tdd.design_system.BookInfoPages
import com.tdd.design_system.BookInfoPrice
import com.tdd.design_system.BookShelfTypo
import com.tdd.design_system.BottomSheet
import com.tdd.design_system.Main2
import com.tdd.design_system.Main3
import com.tdd.design_system.ProgressBottomSheetBtn
import com.tdd.design_system.ProgressBottomSheetNotice
import com.tdd.design_system.ProgressBottomSheetTitle
import com.tdd.design_system.R
import com.tdd.design_system.White4
import com.tdd.domain.entity.response.progress.ProgressBookInfoModel
import com.tdd.ui.common.button.BottomRectangleBtn

@Composable
fun CreateBookInfoBottomSheet(
    onClickClose: () -> Unit,
    bookInfo: ProgressBookInfoModel,
) {

    val interactionSource = remember { MutableInteractionSource() }

    CreateBookInfoContent(
        interactionSource = interactionSource,
        onClickClose = onClickClose,
        bookInfo = bookInfo
    )
}

@Composable
fun CreateBookInfoContent(
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    onClickClose: () -> Unit = {},
    bookInfo: ProgressBookInfoModel = ProgressBookInfoModel(
        "인생기록",
        listOf("인생기록", "나의 인생", "발자취", "걸어온 길"),
        "2025.06.13",
        "2025.06.30",
        300,
        "50,000"
    ),
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackGround)
    ) {
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ProgressBottomSheetTitle,
                    color = Main3,
                    style = BookShelfTypo.head30,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )

                CreateBookInfoBox(
                    bookInfo = bookInfo
                )
            }

            BottomRectangleBtn(
                btnTextContent = ProgressBottomSheetBtn,
                isBtnActivated = true,
                onClickAction = {}
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_close),
            contentDescription = "close",
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 15.dp, end = 15.dp)
                .size(45.dp)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onClickClose
                )
        )
    }
}

@Composable
fun CreateBookInfoBox(
    bookInfo: ProgressBookInfoModel,
) {
    Box(
        modifier = Modifier
            .padding(vertical = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .background(White4)
                .size(width = 230.dp, height = 270.dp)
        )

        Column(
            modifier = Modifier
                .size(width = 230.dp, height = 270.dp)
        ) {
            Text(
                text = "자서전 제목",
                color = Main3,
                style = BookShelfTypo.body50,
                modifier = Modifier
                    .padding(top = 10.dp, start = 15.dp)
            )

            Text(
                text = bookInfo.bookTitles[0],
                color = Black1,
                style = BookShelfTypo.caption40,
                modifier = Modifier
                    .padding(top = 6.dp, start = 15.dp)
            )

            Text(
                text = "출판 예상 시간",
                color = Main3,
                style = BookShelfTypo.body50,
                modifier = Modifier
                    .padding(top = 10.dp, start = 15.dp)
            )

            Row {

                Image(
                    painter = painterResource(id = R.drawable.ic_airplane),
                    contentDescription = "airplane",
                    modifier = Modifier
                        .size(30.dp)
                )
            }

            Row(
                modifier = Modifier
                    .padding(vertical = 30.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.spacedBy(7.dp, Alignment.CenterHorizontally)
            ) {
                CreateBookInfoDetailBox(
                    title = "페이지 수",
                    content = String.format(BookInfoPages, bookInfo.page),
                    detailIcon = R.drawable.ic_book_pages
                )

                CreateBookInfoDetailBox(
                    title = "예상 가격",
                    content = String.format(BookInfoPrice, bookInfo.price),
                    detailIcon = R.drawable.ic_book_price
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = ProgressBottomSheetNotice,
                color = Black1,
                style = BookShelfTypo.caption40,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 15.dp)
            )
        }
//        Image(
//            painter = painterResource(id = R.drawable.ic_ticket),
//            contentDescription = "background"
//        )
    }
}

@Composable
fun CreateBookInfoDetailBox(
    title: String,
    content: String,
    detailIcon: Int
) {
    Column(
        modifier = Modifier
            .background(BottomSheet)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 10.dp, start = 6.dp)
        ) {
            Image(
                painter = painterResource(id = detailIcon),
                contentDescription = "detail",
                modifier = Modifier
                    .size(20.dp)
            )

            Text(
                text = title,
                color = Main3,
                style = BookShelfTypo.body50
            )
        }

        Text(
            text = content,
            color = Main2,
            style = BookShelfTypo.caption40,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp, top = 10.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewCreateBookInfo() {
    CreateBookInfoContent()
}