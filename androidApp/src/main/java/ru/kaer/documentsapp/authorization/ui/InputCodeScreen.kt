package ru.kaer.documentsapp.authorization.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import ru.kaer.documentsapp.android.R
import ru.kaer.documentsapp.authorization.viewmodel.InputCodeScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun InputCodeScreen(
    viewModel: InputCodeScreenViewModel = viewModel(),
    onSuccess: () -> Unit
) {
    val state = viewModel.inputCodeState
    LaunchedEffect(key1 = state.error, block = {
        if (state.error){
            delay(500L)
            viewModel.resetError()
        }
    })


    Scaffold(
//        contentWindowInsets =
//        WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal),
        containerColor = Color(0xFFCEEDDB)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.statusBarsPadding())
            Row(
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                (0..3).forEach {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(
                                color = if (state.error) {
                                    Color.Red
                                } else {
                                    state.inputCode
                                        .getOrNull(it)
                                        ?.let {
                                            Color.Green
                                        } ?: Color.Black
                                },
                                CircleShape
                            ),
                    )
                }
            }
            FlowRow(
                modifier = Modifier.padding(16.dp),
            ) {
                (0..9).forEach {
                    if (it == 9){
                        Spacer(
                            modifier = Modifier
                                .size(100.dp))
                    }
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clickable {
                                viewModel.inputCode("$it", onSuccess)
                            },
                        contentAlignment = Alignment.Center
                    ){

                        Text(
                            text ="$it",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    if (it == 9){
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    viewModel.removeSymbol()
                                },
                            contentAlignment = Alignment.Center){
                            Text(text = "Стереть")
                        }
                    }
                }
            }
        }



    }
}