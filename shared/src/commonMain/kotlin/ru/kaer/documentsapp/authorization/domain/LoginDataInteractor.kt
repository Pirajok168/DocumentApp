package ru.kaer.documentsapp.authorization.domain

import ru.kaer.documentsapp.shared.model.Code

interface LoginDataInteractor {
    var loginCode: Code?
    var accessToken: String?
    var refreshToken: String
    fun fio(): String

    fun isUserAuthorized(): Boolean

    fun checkCode(code: String): Boolean

    fun registration(fio: String)

    fun createCode(code: String)
}