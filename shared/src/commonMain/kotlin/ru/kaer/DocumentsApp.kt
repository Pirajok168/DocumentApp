package ru.kaer

import org.kodein.di.DI
import org.kodein.di.DirectDI
import org.kodein.di.direct
import ru.kaer.documentsapp.authorization.domain.di.DiAuthDomain
import ru.kaer.documentsapp.shared.data.di.DISharedModule
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object DocumentsApp{
    internal val di: DirectDI
        get() = requireNotNull(_di)
    private var _di: DirectDI? = null

    init {
        if (_di != null) {
            _di = null
        }

        val direct = DI {
            importAll(
                DISharedModule,
                DiAuthDomain
            )
        }.direct

        _di = direct
    }
}

