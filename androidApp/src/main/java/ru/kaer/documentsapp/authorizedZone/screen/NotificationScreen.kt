package ru.kaer.documentsapp.authorizedZone.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kaer.documentsapp.android.R
import ru.kaer.documentsapp.authorizedZone.component.NoticeCard

@Composable
fun NotificationScreen() {
    val list = listOf(
        NoticeCard("Выписка по оценкам", "Справка готова"),

        NoticeCard("Справка о доходах", "Справка готова"),

        NoticeCard("Справка в ПФР", "Проблема оформления"),
    )
    Scaffold(
        containerColor = Color(0xFFCEEDDB),
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.statusBarsPadding())
            TextField(
                value = "",
                onValueChange = {},
                label =  {
                    Text(text = "Название справки")
                },
                modifier = Modifier
                    .fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = null)
                }
            )
            Spacer(modifier = Modifier.statusBarsPadding())


            list.forEach {
                NoticeCardComp(
                    title = it.title,
                    status = it.status,
                )
                Spacer(modifier = Modifier.size(15.dp))
            }
        }
    }
}

@Composable
fun NoticeCardComp(title: String, status: String){
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.fillMaxWidth()){
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Text(
                        text = title,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = status,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Box(modifier = Modifier.matchParentSize().padding(8.dp), contentAlignment = Alignment.CenterEnd){
                    Icon(
                        painter = painterResource(id = R.drawable.chevron_right),
                        contentDescription = "",
                        tint = Color.Black
                    )
                }

            }


        }

    }
}