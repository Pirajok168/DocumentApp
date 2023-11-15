package ru.kaer.documentsapp.shared.data.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import ru.kaer.documentsapp.shared.data.DocumentDatabaseImpl
import ru.kaer.documentsapp.shared.data.IDocumentDatabase
import ru.kaer.documentsapp.shared.data.databaseFactory

internal val DISharedModule = DI.Module("DISharedModule"){
    bind< IDocumentDatabase>() with singleton {
        DocumentDatabaseImpl(
            sqlDriver = databaseFactory().sqlDriver
        )
    }
}