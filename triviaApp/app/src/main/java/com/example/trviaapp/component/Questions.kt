package com.example.trviaapp.component

import android.R
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trviaapp.model.Question
import com.example.trviaapp.model.QuestionItem
import com.example.trviaapp.screens.QuestionViewModel
import com.example.trviaapp.utils.AppColors

@Composable
fun Questions(viewModel: QuestionViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    val questionIndex = remember {
        mutableStateOf(0)
    }


    if (viewModel.data.value.loading == true) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        val question = try {
            questions?.get(questionIndex.value)
        } catch (e: Exception) {
            null
        }
        if (questions != null) {
            QuestionDisplay(
                question = question!!,
                questionIndex = questionIndex,
                viewModel = viewModel
            ) {
                questionIndex.value = questionIndex.value + 1
            }
        }

    }
}

@Composable
fun QuestionDisplay(
    question: QuestionItem,
    questionIndex: MutableState<Int>,
    viewModel: QuestionViewModel,
    onNextClicked: (Int) -> Unit
) {
    val choiceState = remember(question) {
        question.choices.toMutableList()
    }
    val answerState = remember(question) {
        mutableStateOf<Int?>(null)
    }

    val correctAnswerState = remember(question) {
        mutableStateOf<Boolean?>(null)
    }
    val updateAnswer: (Int) -> Unit = remember(question) {
        {
            answerState.value = it
        }
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(4.dp),
        color = AppColors.mDarkBlue
    ) {
        Column(
            modifier = Modifier.padding(top = 48.dp, start = 12.dp, end = 12.dp, bottom = 12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            if (questionIndex.value >= 3) {
                ShowProgressMeter(score = questionIndex.value)
            }

            QuestionTracker(
                counter = questionIndex.value,
                outOf = viewModel.getTotalQuestionCount()
            )
            DottedLine(pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f))

            Column() {
                Text(
                    text = question.question,
                    modifier = Modifier
//                        .padding(top = 24.dp, start = 6.dp, end = 6.dp, bottom = 6.dp)
                        .padding(12.dp)
                        .align(alignment = Alignment.Start)
                        .fillMaxHeight(0.3f),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 28.sp,
                    color = AppColors.mWhite
                )
                choiceState.forEachIndexed { index, answerText ->
                    Row(
                        modifier = Modifier
                            .padding(3.dp)
                            .fillMaxWidth()
                            .height(45.dp)
                            .border(
                                width = 4.dp,
                                color = AppColors.mLightGray,
                                shape = RoundedCornerShape(15.dp)
                            )
                            .clip(
                                RoundedCornerShape(
                                    topStartPercent = 50,
                                    topEndPercent = 50,
                                    bottomStartPercent = 50,
                                    bottomEndPercent = 50
                                )
                            )
                            .background(Color.Transparent),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (answerState.value == index),
                            onClick = {
                                updateAnswer(index)
                            },
                            modifier = Modifier.padding(start = 16.dp),
                            colors = RadioButtonDefaults.colors(
                                unselectedColor = AppColors.mLightGray,
                                selectedColor = AppColors.mWhite
                            )
                        )
                        val annotatedString = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Light, color =
                                        if ((correctAnswerState.value == true) && (index == answerState.value)) {
                                            Color.Green
                                        } else if ((correctAnswerState.value == false) && (index == answerState.value)) {
                                            Color.Red
                                        } else {
                                            AppColors.mWhite
                                        }
                                )
                            ) {
                                append(answerText)
                            }
                        }
                        Text(text = annotatedString, modifier = Modifier.padding(6.dp))

                    }
                }

                Button(
                    onClick = { onNextClicked(questionIndex.value) },
                    modifier = Modifier
                        .padding(3.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    shape = RoundedCornerShape(34.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.mDarkPurple,
                    )
                ) {
                    Text(
                        text = "Next",
                        modifier = Modifier.padding(4.dp),
                        color = AppColors.mWhite,
                        fontSize = 24.sp
                    )
                }

            }

        }
    }
}

@Composable
fun DottedLine(pathEffect: PathEffect) {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
    ) {
        drawLine(
            color = AppColors.mLightGray,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}

@Composable
fun QuestionTracker(counter: Int = 10, outOf: Int = 100) {
    Text(text = buildAnnotatedString {
        withStyle(style = ParagraphStyle(textIndent = TextIndent.None)) {
            withStyle(
                style = SpanStyle(
                    color = AppColors.mLightGray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
            ) {
                append("Question $counter")
            }
            withStyle(
                style = SpanStyle(
                    color = AppColors.mLightGray,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                )
            ) {
                append(" of $outOf")
            }
        }
    }, modifier = Modifier.padding(20.dp))

}

@Composable
fun ShowProgressMeter(score: Int = 12) {
    Row(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(45.dp)
            .border(
                width = 4.dp, brush = Brush.linearGradient(
                    colors = listOf(
                        AppColors.mWhite, AppColors.mLightGray
                    )
                ), shape = RoundedCornerShape(34)
            )
            .clip(
                RoundedCornerShape(
                    topStartPercent = 50,
                    topEndPercent = 50,
                    bottomEndPercent = 50,
                    bottomStartPercent = 50
                )
            )
            .background(Color.Transparent), verticalAlignment = Alignment.CenterVertically
    ) {
        val gradientColor = Brush.linearGradient(listOf(Color(0xFFF95075), Color(0xFFBE6BE5)))
        val progressFactor = remember(score) {
            mutableFloatStateOf(score * 0.005f)
        }

        Button(
            contentPadding = PaddingValues(1.dp),
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(progressFactor.floatValue)
                .background(brush = gradientColor),
            enabled = false,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            )
        ) {
            Text(
                text = (score * 10).toString(),
                modifier = Modifier
                    .clip(
                        shape = RoundedCornerShape(
                            23.dp
                        )
                    )
                    .fillMaxHeight(0.87f)
                    .fillMaxWidth()
                    .padding(6.dp),
                color = AppColors.mWhite,
                textAlign = TextAlign.Center
            )
        }

    }
}