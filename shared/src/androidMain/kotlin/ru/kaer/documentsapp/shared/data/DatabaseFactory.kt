package ru.kaer.documentsapp.shared.data

import android.content.Context
import androidx.sqlite.db.SupportSQLiteDatabase
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import ru.kaer.documentsapp.ContextApplication
import ru.kaer.documentsapp.DocumentDatabase


class DatabaseDriverFactory(
    private val context: Context = ContextApplication.getContextApplication().context
): IDatabaseFactory {
    override val sqlDriver: SqlDriver
        get() = AndroidSqliteDriver(
            DocumentDatabase.Schema,
            context,
            "esstustudent.db",
            callback = object : AndroidSqliteDriver.Callback(DocumentDatabase.Schema) {
                override fun onConfigure(db: SupportSQLiteDatabase) {
                    super.onConfigure(db)
                    db.setForeignKeyConstraintsEnabled(true)
                }
            })

}

actual fun databaseFactory(): IDatabaseFactory = DatabaseDriverFactory()