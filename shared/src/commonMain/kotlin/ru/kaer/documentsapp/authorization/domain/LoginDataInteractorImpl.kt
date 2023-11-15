package ru.kaer.documentsapp.authorization.domain

import ru.kaer.documentsapp.authorization.data.LoginDataRepository
import ru.kaer.documentsapp.shared.model.Code

class LoginDataInteractorImpl(
    private val loginDataRepository: LoginDataRepository
): LoginDataInteractor {
    override var loginCode: Code? = loginDataRepository.loginCode
    override var accessToken: String? = loginDataRepository.accessToken
    override var refreshToken: String = loginDataRepository.refreshToken

    override fun isUserAuthorized(): Boolean  =
        loginDataRepository.isUserAuthorized()
}