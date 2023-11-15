package ru.kaer.documentsapp.authorizedZone.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import ru.kaer.documentsapp.authorizedZone.component.ReferenceCard

@Composable
fun MainScreen() {
    val list = listOf(
        ReferenceCard(
            title = "Для студентов",
            R.drawable.student,
            listOf(
                "Архивная справка",
                    "Справка о периоде обучения",
                    "Справка о прохождении ВЦ"
            )
        ),
        ReferenceCard(
            title = "Для сотрудников",
            R.drawable.employee,
            listOf(
                "Справка в соц.защиту",
                "Справка 2-НДФЛ",
                "Справка о стаже",
            )
        ),
        ReferenceCard(
            title = "Для выпускников",
            R.drawable.student_all,
            listOf(
                "Архивная справка",
                "Справка о периоде обучения",
                "Справка о прохождении ВЦ"
            )
        )
    )
    Scaffold(
        containerColor = Color(0xFFCEEDDB),
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(horizontal = 16.dp)) {
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
                CardReference(
                    title = it.title,
                    icon = it.icon,
                    description = it.descriptions.joinToString("\n")
                )
                Spacer(modifier = Modifier.size(15.dp))
            }
        }
    }
}


@Composable
fun CardReference(
    title: String,
    @DrawableRes icon: Int,
    description: String
) {
    ElevatedCard(
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            Column {
                Text(
                    text = title,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.size(6.dp))

                Text(
                    text = description,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
        