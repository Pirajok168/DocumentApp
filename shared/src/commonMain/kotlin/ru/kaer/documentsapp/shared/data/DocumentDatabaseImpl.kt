package ru.kaer.documentsapp.shared.data

import app.cash.sqldelight.ColumnAdapter
import app.cash.sqldelight.adapter.primitive.IntColumnAdapter
import app.cash.sqldelight.db.SqlDriver
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.kaer.documentsapp.CodeTable
import ru.kaer.documentsapp.DocumentDatabase
import ru.kaer.documentsapp.shared.model.LoginType

class DocumentDatabaseImpl(
    sqlDriver: SqlDriver
) : IDocumentDatabase {
    private val adapter = object : ColumnAdapter<LoginType, String> {
        override fun decode(databaseValue: String): LoginType {
            return Json { }.decodeFromString(databaseValue)
        }

        override fun encode(value: LoginType): String {
            return Json { }.encodeToString(value)
        }

    }

    private val database = DocumentDatabase(sqlDriver,CodeTable.Adapter(adapter))

    override fun getDataBase(): DocumentDatabase = database

}