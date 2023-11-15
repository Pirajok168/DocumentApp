package ru.kaer.documentsapp.authorization.data

import ru.kaer.documentsapp.DocumentDatabase
import ru.kaer.documentsapp.shared.model.Code

class LoginDataRepositoryImpl(
    database: DocumentDatabase
): LoginDataRepository {
    private val dbQuery = database.codeTableQueries
    private val tokenTable = database.tokenTableQueries
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

    override fun isUserAuthorized(): Boolean =
        tokenTable.isUserAuthorized().executeAsOneOrNull() != null
}