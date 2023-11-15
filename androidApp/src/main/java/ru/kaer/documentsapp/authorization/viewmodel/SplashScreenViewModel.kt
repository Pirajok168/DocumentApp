package ru.kaer.documentsapp.authorization.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.kaer.DocumentsApp
import ru.kaer.documentsapp.authorization.domain.LoginDataInteractor
import ru.kaer.documentsapp.authorization.domain.di.dialogChatModuleNew
import ru.kaer.documentsapp.shared.model.Code

data class AuthState(
    val code: Code? = null,
    val isLoading: Boolean = false,
    val isAuthorizedInApp: Boolean? = null
)


class SplashScreenViewModel(
    private val loginDataInteractor: LoginDataInteractor = DocumentsApp.dialogChatModuleNew.loginDataInteractor
): ViewModel() {
    var authState by mutableStateOf(AuthState())
        private set

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val isAuthorizedInApp = loginDataInteractor.isUserAuthorized()
            withContext(Dispatchers.Main){
                authState = authState.copy(
                    isAuthorizedInApp = isAuthorizedInApp
                )
            }
        }

    }
}