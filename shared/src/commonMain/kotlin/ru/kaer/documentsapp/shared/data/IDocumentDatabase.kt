package ru.kaer.documentsapp.shared.data

import ru.kaer.documentsapp.DocumentDatabase

interface IDocumentDatabase {
    fun getDataBase(): DocumentDatabase
}