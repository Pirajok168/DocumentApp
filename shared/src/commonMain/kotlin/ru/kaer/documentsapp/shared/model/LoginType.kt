@file:Suppress("unused")

package ru.kaer.documentsapp.shared.model

import kotlinx.serialization.Serializable

// Enum can not be declared as expect/actual without representing all members, so just mixing it.
//
@Serializable
enum class LoginType {

    // Android specific
    BIOMETRIC,

    // Ios specific
    FACE,
    FINGER,

    // Shared
    CODE,

    UNDEFINED
}
