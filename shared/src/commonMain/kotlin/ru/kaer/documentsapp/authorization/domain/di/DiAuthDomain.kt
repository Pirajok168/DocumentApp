package ru.kaer.documentsapp.authorization.domain.di

import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton
import ru.kaer.DocumentsApp
import ru.kaer.documentsapp.authorization.data.LoginDataRepository
import ru.kaer.documentsapp.authorization.data.LoginDataRepositoryImpl
import ru.kaer.documentsapp.authorization.domain.LoginDataInteractor
import ru.kaer.documentsapp.authorization.domain.LoginDataInteractorImpl
import ru.kaer.documentsapp.shared.data.IDatabaseFactory
import ru.kaer.documentsapp.shared.data.IDocumentDatabase
import kotlin.native.concurrent.ThreadLocal

internal val DiAuthDomain = DI.Module("DiAuthDomain"){
    bind<LoginDataRepository>() with singleton {
        LoginDataRepositoryImpl(
            database = instance<IDocumentDatabase>().getDataBase(), instance(), instance()
        )
    }

    bind<LoginDataInteractor>() with singleton {
        LoginDataInteractorImpl(
            instance()
        )
    }
}

@ThreadLocal
object DiAuthDomainModule {
    val loginDataInteractor: LoginDataInteractor
        get() = DocumentsApp.di.instance()
}

val DocumentsApp.dialogChatModuleNew: DiAuthDomainModule
    get() = DiAuthDomainModule