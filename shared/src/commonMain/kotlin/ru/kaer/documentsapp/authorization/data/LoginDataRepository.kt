package ru.kaer.documentsapp.authorization.data

import ru.kaer.documentsapp.shared.model.Code

interface LoginDataRepository {
    var loginCode: Code?
    var accessToken: String?
    var refreshToken: String
    fun getFio(): String

    fun isUserAuthorized(): Boolean

    fun registration(fio: String)

    fun createCode(code: String)

}