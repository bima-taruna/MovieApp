package com.bima.movieapp.domain.repository

interface DataStoreRepository {
    suspend fun setUiMode(value:Boolean)
    suspend fun getUiMode(key : String): Boolean?
}