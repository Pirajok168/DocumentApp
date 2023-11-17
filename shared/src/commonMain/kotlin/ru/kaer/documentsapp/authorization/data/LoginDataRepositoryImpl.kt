package ru.kaer.documentsapp.authorization.data

import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import ru.kaer.documentsapp.AppplicTable
import ru.kaer.documentsapp.DocumentDatabase
import ru.kaer.documentsapp.authorization.api.HttpClientMobile
import ru.kaer.documentsapp.shared.model.Code
import ru.kaer.documentsapp.shared.model.LoginType

class LoginDataRepositoryImpl(
    database: DocumentDatabase,
    private val api: HttpClientMobile,
    private val scope: CoroutineScope
): LoginDataRepository {
    private val dbQuery = database.codeTableQueries
    private val tokenTable = database.tokenTableQueries
    private val fioTable = database.fioTableQueries
    private val appTable = database.appplickTableQueries
    override var loginCode: Code?
        get() {
            return dbQuery.getCode().executeAsOneOrNull()?.let {
                return@let Code(it.code, it.loginType)
            }
        }
        set(value) {
            val code = requireNotNull(value)
            dbQuery.setCode(code.code, code.loginType)
        }

    override var accessToken: String?
        get() {
           return  null
        }
        set(value) {}

    override var refreshToken: String
        get() {
            return ""
        }
        set(value) {}

    override fun getFio(): String
         = fioTable.getFio().executeAsOneOrNull().orEmpty()

    override fun isUserAuthorized(): Boolean =
        tokenTable.isUserAuthorized().executeAsOneOrNull() != null

    override fun registration(fio: String) {
        fioTable.setFio(fio)
        scope.launch {
            val token = api.registration()
            tokenTable.setAuthorized(token.token, token.refreshToken)
        }

    }

    override fun createCode(code: String) {
        loginCode = Code(code, LoginType.CODE)
    }

    override fun createApplication(
        fio: String,
        kafedra: String,
        kurs: String,
        grupa: String,
        title: String
    ) {
        scope.launch {
            api.sendDocument()
            appTable.setApp(fio, kafedra, kurs, grupa, "Справка готова", title)
        }

    }

    override fun getApplications(): List<AppplicTable> {
        scope.launch {
            return@launch api.getNotification()
        }
    }

}