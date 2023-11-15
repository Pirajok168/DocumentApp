package ru.kaer.documentsapp.authorization.domain

import ru.kaer.documentsapp.shared.model.Code

interface LoginDataInteractor {
    var loginCode: Code?
    var accessToken: String?
    var refreshToken: String

    fun isUserAuthorized(): Boolean
}