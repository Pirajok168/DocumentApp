package ru.kaer.documentsapp.authorizedZone

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
import ru.kaer.documentsapp.authorization.viewmodel.RegistrationScreenState

data class RegistrationApplicationState(
    val fio: String = "",
    val kafedra: String = "",
    val kurs: String = "",
    val grupa: String = ""
)

class RegistrationApplicationViewModel(
    private val loginDataInteractor: LoginDataInteractor = DocumentsApp.dialogChatModuleNew.loginDataInteractor
): ViewModel() {
    var registrationApplicationState by mutableStateOf(RegistrationApplicationState())
        private set

    fun createApplication(title: String){
        registrationApplicationState.run {
            viewModelScope.launch(Dispatchers.IO) {
                loginDataInteractor.createApplication(fio, kafedra, kurs, grupa, title)
            }

        }
    }

    fun inputgrupa(value: String){
        updateWithMainFlow{
            registrationApplicationState = registrationApplicationState
                .copy(grupa = value)
        }
    }

    fun inputKurs(value: String){
        updateWithMainFlow{
            registrationApplicationState = registrationApplicationState
                .copy(kurs = value)
        }
    }

    fun inputKafedra(value: String){
        updateWithMainFlow{
            registrationApplicationState = registrationApplicationState
                .copy(kafedra = value)
        }
    }

    init {
        updateWithMainFlow {
            registrationApplicationState = registrationApplicationState.copy(
                fio = loginDataInteractor.fio()
            )
        }
    }
    private inline fun updateWithMainFlow(crossinline update: () -> Unit) =
        viewModelScope.launch() {
            withContext(Dispatchers.Main){
                update()
            }
        }
}