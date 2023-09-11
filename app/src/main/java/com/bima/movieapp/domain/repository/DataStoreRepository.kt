package com.bima.movieapp.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun setUiMode(value:Boolean)
    suspend fun getUiMode(key : String): Flow<Boolean>
}