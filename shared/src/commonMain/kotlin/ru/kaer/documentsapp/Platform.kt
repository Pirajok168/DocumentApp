package ru.kaer.documentsapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform