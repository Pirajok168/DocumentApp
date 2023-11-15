package ru.kaer.documentsapp.authorization.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kaer.documentsapp.android.R
import ru.kaer.documentsapp.authorization.viewmodel.RegistrationScreenViewModel

@Composable
fun RegistrationScreen(
    viewModel: RegistrationScreenViewModel = viewModel(),
    onSuccess: () -> Unit
) {
    val state = viewModel.authState
    Scaffold(
        contentWindowInsets =
        WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal),
        containerColor = Color(0xFFCEEDDB)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .verticalScroll(rememberScrollState())
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.statusBarsPadding())
            Image(
                painter = painterResource(id = R.drawable.is_registration),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            Text(text = "Регистрация", fontSize = 32.sp, fontWeight = FontWeight.Normal)

            Spacer(modifier = Modifier.size(32.dp))

            TextField(
                value = state.fio,
                onValueChange = {viewModel.inputFio(it)},
                label =  {
                    Text(text = "ФИО")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))

            TextField(
                value = state.birthday,
                onValueChange = {viewModel.inputBirthday(it)},
                label =  {
                    Text(text = "Дата рождения")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))

            TextField(
                value = state.login,
                onValueChange = {viewModel.inputLogin(it)},
                label =  {
                    Text(text = "Логин")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))

            TextField(
                value = state.password,
                onValueChange = {viewModel.inputPassword(it)},
                label =  {
                    Text(text = "Пароль")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.size(10.dp))

            TextField(
                value = state.repeatPassword,
                onValueChange = {viewModel.inputRepeatPassword(it)},
                label =  {
                    Text(text = "Повторите пароль")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                supportingText = {
                    if (state.error)
                        Text(text = "Пароли не совпадают", color = Color.Red)
                }
            )
            Spacer(modifier = Modifier.size(35.dp))

            Button(
                onClick = { viewModel.onRegistration(onSuccess) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 49.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    disabledContainerColor = Color.Gray
                ),
                enabled = state.fio.isNotEmpty() && state.password.isNotEmpty() && state.repeatPassword.isNotEmpty() && state.login.isNotEmpty()
            ) {
                Text(
                    text = "Зарегистрироваться",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}