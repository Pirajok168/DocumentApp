package ru.kaer.documentsapp.authorization.api

import ru.kaer.documentsapp.AppplicTable
import ru.kaer.documentsapp.TokenTable

interface HttpClientMobile {
    suspend fun registration(): TokenTable

    suspend fun sendDocument()

    suspend fun getNotification(): List<AppplicTable>


    suspend fun refreshToken(refreshToken: String): TokenTable
}