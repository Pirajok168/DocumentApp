package ru.kaer.documentsapp.shared.data

import app.cash.sqldelight.db.SqlDriver


interface IDatabaseFactory {
    val sqlDriver: SqlDriver
}

expect fun databaseFactory(): IDatabaseFactory