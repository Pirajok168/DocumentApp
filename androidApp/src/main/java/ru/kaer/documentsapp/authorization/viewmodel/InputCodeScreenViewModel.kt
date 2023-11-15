package ru.kaer.documentsapp.authorization.viewmodel

import android.view.View
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


data class InputCodeScreenState(
    val inputCode: String = "",
    val success: Boolean = false,
    val error: Boolean = false
)
class InputCodeScreenViewModel(
    private val loginDataInteractor: LoginDataInteractor = DocumentsApp.dialogChatModuleNew.loginDataInteractor
): ViewModel() {
    var inputCodeState by mutableStateOf(InputCodeScreenState())
        private set

    fun resetError(){
        updateWithMainFlow{
            inputCodeState = inputCodeState.copy(inputCode = "", error = false)
        }
    }
    fun inputCode(value:String, onSuccess: () -> Unit){
        updateWithMainFlow{
            inputCodeState = inputCodeState.copy(inputCode = inputCodeState.inputCode + value)
        }
        if (inputCodeState.inputCode.length == 4) {
            val isCheck = loginDataInteractor.checkCode(inputCodeState.inputCode)
            updateWithMainFlow{
                inputCodeState = inputCodeState.copy(success = isCheck, error = !isCheck)
            }
            if (isCheck){
                onSuccess()
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