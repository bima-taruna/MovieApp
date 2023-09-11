package com.bima.movieapp.domain.use_case.ui_mode

import com.bima.movieapp.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUiMode @Inject constructor(
    private val repository: DataStoreRepository
) {
    suspend operator fun invoke(key:String) : Flow<Boolean> {
        return repository.getUiMode(key)
    }
}