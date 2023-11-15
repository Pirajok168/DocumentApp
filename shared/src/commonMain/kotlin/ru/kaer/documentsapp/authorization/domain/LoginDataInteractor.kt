package ru.kaer.documentsapp.authorization.domain

import ru.kaer.documentsapp.AppplicTable
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

    fun createApplication(fio: String, kafedra: String, kurs: String, grupa: String,  title: String)

    fun getApplications(): List<AppplicTable>
}