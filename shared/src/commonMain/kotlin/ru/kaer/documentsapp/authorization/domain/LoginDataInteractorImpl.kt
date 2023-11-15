package ru.kaer.documentsapp.authorization.domain

import ru.kaer.documentsapp.authorization.data.LoginDataRepository
import ru.kaer.documentsapp.shared.model.Code
import ru.kaer.documentsapp.shared.model.LoginType

class LoginDataInteractorImpl(
    private val loginDataRepository: LoginDataRepository
): LoginDataInteractor {
    override var loginCode: Code? = loginDataRepository.loginCode
    override var accessToken: String? = loginDataRepository.accessToken
    override var refreshToken: String = loginDataRepository.refreshToken

    override fun isUserAuthorized(): Boolean  =
        loginDataRepository.isUserAuthorized()

    override fun checkCode(code: String): Boolean =
        loginCode?.code == code

    override fun registration() = loginDataRepository.registration()

    override fun createCode(code: String) = loginDataRepository.createCode(code)

}