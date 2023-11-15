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

data class RegistrationScreenState(
    val fio: String = "",
    val birthday: String = "",
    val login: String = "",
    val password: String = "",
    val repeatPassword: String = "",
    val error: Boolean = false
)

class RegistrationScreenViewModel(
    private val loginDataInteractor: LoginDataInteractor = DocumentsApp.dialogChatModuleNew.loginDataInteractor
): ViewModel() {
    var authState by mutableStateOf(RegistrationScreenState())
        private set

    fun onRegistration(onSuccess: () -> Unit){
        if (authState.password != authState.repeatPassword ){
            updateWithMainFlow {
                authState = authState.copy(error = true)
            }
            return
        }
        loginDataInteractor.registration()
        onSuccess()
    }

    fun inputRepeatPassword(value: String){
        updateWithMainFlow {
            authState = authState.copy(repeatPassword = value)
        }
    }
    fun inputPassword(value: String){
        updateWithMainFlow {
            authState =authState.copy(password = value)
        }
    }
    fun inputLogin(value: String){
        updateWithMainFlow {
            authState =authState.copy(login = value)
        }
    }
    fun inputBirthday(value: String){
        updateWithMainFlow {
            authState =authState.copy(birthday = value)
        }
    }
    fun inputFio(value: String){
        updateWithMainFlow {
            authState =authState.copy(fio = value)
        }
    }


    private inline fun updateWithMainFlow(crossinline update: () -> Unit) =
        viewModelScope.launch() {
            withContext(Dispatchers.Main){
                update()
            }
        }
}