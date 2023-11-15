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


data class CreateCodeScreenState(
    val inputCode: String = "",
    val createdCode: Boolean = false
)
class CreateInputCodeScreenViewModel(
    private val loginDataInteractor: LoginDataInteractor = DocumentsApp.dialogChatModuleNew.loginDataInteractor
): ViewModel() {
    var inputCodeState by mutableStateOf(CreateCodeScreenState())
        private set

    fun inputCode(value:String){
        updateWithMainFlow{
            inputCodeState = inputCodeState.copy(inputCode = inputCodeState.inputCode + value)
        }
        if (inputCodeState.inputCode.length == 4) {
            loginDataInteractor.createCode(inputCodeState.inputCode)
            updateWithMainFlow {
                inputCodeState = inputCodeState.copy(createdCode = true)
            }
        }
    }

    fun removeSymbol(){
        if (inputCodeState.inputCode.isEmpty()) return
        updateWithMainFlow{
            inputCodeState = inputCodeState.copy(inputCode = inputCodeState.inputCode.dropLast(1))
        }
    }

    private inline fun updateWithMainFlow(crossinline update: () -> Unit) =
        viewModelScope.launch() {
            withContext(Dispatchers.Main){
                update()
            }
        }
}