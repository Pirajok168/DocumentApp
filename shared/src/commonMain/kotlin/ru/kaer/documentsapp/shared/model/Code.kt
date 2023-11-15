package ru.kaer.documentsapp.shared.model

import kotlinx.serialization.Serializable


@Serializable
data class Code(val code: String, val loginType: LoginType? = null)
