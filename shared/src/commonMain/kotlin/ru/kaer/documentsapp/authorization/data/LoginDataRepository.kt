package ru.kaer.documentsapp.authorization.data

import ru.kaer.documentsapp.shared.model.Code

interface LoginDataRepository {
    var loginCode: Code?
    var accessToken: String?
    var refreshToken: String

    fun isUserAuthorized(): Boolean

}