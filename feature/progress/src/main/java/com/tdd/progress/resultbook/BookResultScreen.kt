package com.tdd.progress.resultbook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tdd.design_system.BackGround
import com.tdd.design_system.Black1
import com.tdd.design_system.BookShelfTypo
import com.tdd.design_system.Gray5
import com.tdd.design_system.R

@Composable
fun BookResultScreen(
    goBack: () -> Unit = {}
) {
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackGround)
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_book_example),
                contentDescription = "book background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )

            Text(
                text = "인생 기록",
                color = Black1,
                style = BookShelfTypo.head20,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = 20.dp)
            )

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
                        onClick = { goBack() }
                    )
            )
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {

                Text(
                    text = "1. 성장 과정",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "나는 1965년 봄, 작은 시골 마을의 개울가 옆에서 태어났다. 흙먼지 날리는 골목에서 뛰어놀고, 개울물에 발 담그고 가재를 잡던 어린 시절은 순수함 그 자체였다. 아버지는 묵묵히 논밭을 일구셨고, 어머니는 언제나 따뜻한 밥상과 넉넉한 웃음으로 우리 삼남매를 품어주셨다. 특별한 장난감이 없어도 자연은 최고의 놀이터였다. 여름이면 개울에서 물장구치고, 겨울이면 얼어붙은 논바닥에서 썰매를 탔다. 풀벌레 소리가 자장가가 되고, 밤하늘의 별들이 친구가 되어주던 그 시절은 나에게 뿌리 깊은 안정감과 자연에 대한 경외심을 심어주었다. 초등학교 입학 전, 이웃집 할머니가 들려주시던 옛날이야기는 상상의 나래를 펼치는 데 큰 도움이 되었고, 작은 마을 도서관에서 처음 만난 그림책들은 나에게 세상의 문을 열어주었다. 나는 그때부터 막연하게 '넓은 세상'을 동경하기 시작했다. 비록 부족함 속에서 자랐지만, 그 시절의 모든 경험은 훗날 내가 어떤 어려움에 부딪혔을 때도 긍정적인 마음과 강한 생명력으로 버틸 수 있게 해준 소중한 자산이 되었다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                )

                Text(
                    text = "2. 가족 관계",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "우리 집은 늘 웃음소리가 끊이지 않는 곳이었다. 엄하면서도 자상했던 아버지, 그리고 한없이 너그럽고 지혜로웠던 어머니는 나의 첫 번째 스승이자 영원한 안식처였다. 삼남매 중 둘째였던 나는 위로는 든든한 형이, 아래로는 귀여운 여동생이 있었다. 형과는 어릴 적부터 장난치고 다투기도 했지만, 언제나 나의 편이 되어주던 든든한 버팀목이었다. 동생에게는 오빠로서의 책임감과 애틋함이 공존했다. 명절이면 온 가족이 모여 앉아 시끌벅적하게 이야기를 나누고, 갓 지은 밥과 어머니의 손맛이 담긴 음식들을 나눠 먹으며 가족의 의미를 되새겼다. 결혼 후, 나의 배우자와 아이들은 또 다른 형태의 가족을 선물해주었다. 서로를 존중하고 사랑하며 함께 성장하는 과정을 통해 가족은 단순한 혈연 관계를 넘어선 '운명 공동체'이자 '삶의 가장 견고한 울타리'라는 것을 깨달았다. 때로는 갈등과 오해가 있었지만, 결국 사랑과 이해로 모든 것을 극복하며 우리는 더 단단해졌다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                )

                Text(
                    text = "3. 학창 시절",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "중학교 시절, 나는 처음으로 도시로 유학을 왔다. 시골과는 너무도 다른 환경은 나에게 새로운 자극과 함께 약간의 두려움을 안겨주었다. 하지만 낯선 환경에서도 나는 책과 공부에 몰두했다. 특히 과학 과목에 흥미를 느껴 밤늦도록 실험 도구를 가지고 씨름하곤 했다. 고등학교 때는 문과와 이과 중 진로를 결정해야 하는 기로에 섰다. 과학에 대한 열정은 여전했지만, 문학 작품을 읽고 글을 쓰는 것에도 큰 즐거움을 느꼈던 터라 고민이 깊었다. 결국 나는 '세상을 더 넓게 이해하고 싶다'는 생각으로 인문계 고등학교를 선택했다. 문학 동아리에서 활동하며 많은 친구들과 밤샘 토론을 벌였고, 나의 가치관과 세상을 바라보는 시야를 넓힐 수 있었다. 비록 입시의 압박 속에서 때로는 힘들었지만, 독서와 토론, 그리고 친구들과의 교류는 나에게 깊은 사유의 힘과 비판적 사고 능력을 길러주었다. 그 시절은 내가 어떤 사람이 될 것인지, 어떤 삶을 살고 싶은지에 대한 첫 질문을 던졌던 시기였다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                )

                Text(
                    text = "4. 직업/진로",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "대학에서 영문학을 전공한 나는 졸업 후 막막함을 느꼈다. 막연히 글을 쓰고 싶다는 생각은 있었지만, 구체적으로 어떤 직업을 가져야 할지 확신이 없었다. 여러 회사에 지원했지만 번번이 고배를 마셨고, 좌절감에 빠지기도 했다. 그러던 중 작은 출판사에서 편집 보조로 일할 기회를 얻었다. 처음에는 단순한 허드렛일이었지만, 책이 만들어지는 과정 하나하나가 신기하고 즐거웠다. 특히 작가의 원고를 다듬고, 독자들이 읽기 쉽게 만드는 편집 작업에서 큰 보람을 느꼈다. 그렇게 몇 년간 경력을 쌓은 후, 나는 좀 더 주체적으로 책을 기획하고 만들고 싶다는 생각에 독립 출판사를 차렸다. 처음에는 자금도 부족하고 인맥도 없어 어려움이 많았지만, 열정과 뚝심으로 버텼다. 몇 년간의 고생 끝에 내가 기획한 책이 베스트셀러가 되었을 때의 그 기쁨은 말로 다 표현할 수 없었다. 나의 직업은 단순히 돈을 버는 수단이 아니라, 나 자신을 표현하고 세상에 기여하는 통로가 되었다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                )

                Text(
                    text = "5. 가치관/성격",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "나의 가치관은 어린 시절부터 형성된 자연과의 교감, 그리고 학창 시절의 독서와 토론, 그리고 사회생활을 통해 점차 확고해졌다. 나는 '정직'과 '성실'을 가장 중요한 덕목으로 여긴다. 아무리 힘들어도 약속은 지키고, 맡은 일은 끝까지 책임지는 것이 나의 철칙이었다. 또한, '경청'의 중요성을 항상 강조한다. 다른 사람의 이야기를 귀 기울여 듣는 것은 단순히 정보를 얻는 것을 넘어, 상대방의 마음을 이해하고 공감하는 가장 좋은 방법이라고 믿는다. 이러한 가치관은 나의 삶의 나침반이 되어 중요한 결정을 내릴 때마다 올바른 길을 안내해 주었다. 나의 성격은 외향적이기보다는 내향적인 편이다. 많은 사람들과 어울리는 것보다는 소수의 사람들과 깊은 관계를 맺는 것을 선호한다. 때로는 우유부단하다는 평을 듣기도 하지만, 신중하게 생각하고 결정하는 것이 나의 방식이다. 이러한 성격 덕분에 나는 어떤 일이든 꼼꼼하게 계획하고 실행하며, 쉽게 포기하지 않는 끈기를 가질 수 있었다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                )

                Text(
                    text = "6. 인생 경험",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "나의 인생은 마치 한 편의 드라마 같았다. 기쁨과 슬픔, 성공과 실패, 만남과 이별이 끊임없이 교차하는 파노라마였다. 가장 기억에 남는 경험 중 하나는 바로 IMF 외환 위기 당시 출판사가 큰 어려움을 겪었던 일이다. 몇 년간 공들여 키웠던 회사가 한순간에 휘청거리자 나는 절망감에 빠졌다. 하지만 포기하지 않았다. 밤샘 연구 끝에 틈새시장을 공략한 새로운 기획으로 회사를 다시 일으켜 세울 수 있었다. 이 경험을 통해 나는 '위기는 곧 기회'라는 것을 절실히 깨달았다. 또한, 소중한 사람들과의 이별은 나에게 삶의 유한함과 소중함을 일깨워주었다. 슬픔 속에서도 나는 삶의 의미를 찾으려 노력했고, 결국 이별 또한 성장의 한 과정임을 받아들였다. 여행은 나의 삶에 큰 영감을 주었다. 낯선 문화를 경험하고 다양한 사람들을 만나면서 나는 세상의 다양성과 아름다움을 깨달았고, 나의 시야를 더욱 넓힐 수 있었다. 이러한 희로애락의 경험들이 나를 단단하게 만들고, 더 넓은 시야로 세상을 바라보게 했다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                )

                Text(
                    text = "7. 감정/취향",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "나는 어릴 적부터 감성적인 면이 강했다. 작은 일에도 쉽게 감동하고, 아름다운 것을 보면 눈물을 글썽이곤 했다. 이러한 감수성은 나에게 문학을 사랑하고, 예술을 즐기는 취향을 선물해주었다. 바흐의 무반주 첼로 모음곡을 들으며 위안을 얻고, 고흐의 그림을 보며 삶의 에너지를 느낀다. 조용히 혼자 생각에 잠기는 것을 좋아하며, 이때 주로 나의 감정과 생각들을 글로 정리하곤 한다. 이는 나의 내면의 소리에 귀 기울이고, 복잡한 감정들을 다스리는 나만의 방법이다. 최근에는 정원 가꾸는 취미를 시작했다. 작은 씨앗에서 싹이 트고, 꽃이 피는 과정을 지켜보는 것은 나에게 큰 평온함과 기쁨을 준다. 자연의 순리를 따르며 성장하는 식물들을 보며 나는 삶의 지혜를 얻기도 한다. 또한, 맛있는 음식을 만들어 소중한 사람들과 나누는 것을 즐긴다. 요리는 나에게 창의적인 즐거움과 함께 사랑을 표현하는 방식이 된다. 이러한 취향들은 나의 삶을 더욱 풍요롭게 만들고, 나 자신을 더 깊이 이해하는 데 도움을 준다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp)
                )

                Text(
                    text = "8. 사회/문화",
                    color = Black1,
                    style = BookShelfTypo.head30,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 30.dp)
                )

                Text(
                    text = "나는 나의 직업을 통해 사회에 기여하는 것에 큰 의미를 둔다. 내가 만든 책들이 독자들에게 새로운 지식과 영감을 주고, 더 나은 세상을 만드는 데 조금이나마 도움이 되기를 바랐다. 특히 소외된 이웃들의 이야기를 담은 책들을 출판하며, 그들의 목소리가 세상에 전달될 수 있도록 노력했다. 은퇴 후에는 지역 사회의 작은 도서관에서 자원봉사를 시작했다. 아이들에게 책을 읽어주고, 고령자들에게 디지털 기기 사용법을 알려주는 활동을 하며 여생의 보람을 느낀다. 빠르게 변화하는 디지털 문화 속에서 고령자들이 소외되지 않고 새로운 기술을 통해 삶을 풍요롭게 할 수 있도록 돕는 것이 나의 작은 목표이다. 또한, K-POP, K-드라마 등 한국 문화가 전 세계적으로 사랑받는 모습을 보며 큰 자부심을 느낀다. 언어와 국경을 넘어 문화로 소통하는 시대에 살고 있다는 것이 감사하다. 나는 앞으로도 세상과 소통하고 배우며, 내가 가진 작은 지식과 경험을 나누어 사회에 긍정적인 발자취를 남기고 싶다. 삶의 마지막 순간까지 배우고 성장하며, 사랑하는 이들과 함께 이 세상의 아름다움을 만끽하고 싶다.",
                    color = Gray5,
                    style = BookShelfTypo.body30,
                    modifier = Modifier
                        .padding(top = 15.dp, start = 30.dp, end = 30.dp, bottom = 50.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewBookResult() {
    BookResultScreen()
}