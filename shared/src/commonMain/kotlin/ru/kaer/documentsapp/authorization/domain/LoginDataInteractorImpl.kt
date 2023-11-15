package ru.kaer.documentsapp.authorization.domain

import ru.kaer.documentsapp.authorization.data.LoginDataRepository
import ru.kaer.documentsapp.shared.model.Code

class LoginDataInteractorImpl(
    private val loginDataRepository: LoginDataRepository
): LoginDataInteractor {
    override var loginCode: Code? = loginDataRepository.loginCode
    override var accessToken: String? = loginDataRepository.accessToken
    override var refreshToken: String = loginDataRepository.refreshToken
    override fun fio(): String = loginDataRepository.getFio()

    override fun isUserAuthorized(): Boolean  =
        loginDataRepository.isUserAuthorized()

    override fun checkCode(code: String): Boolean =
        loginCode?.code == code

    override fun registration(fio: String) = loginDataRepository.registration(fio)

    override fun createCode(code: String) = loginDataRepository.createCode(code)

}