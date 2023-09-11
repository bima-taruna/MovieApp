package com.bima.movieapp.domain.use_case.ui_mode

import com.bima.movieapp.domain.repository.DataStoreRepository
import javax.inject.Inject

class SetUiMode @Inject constructor(
    private val repository: DataStoreRepository
) {
    suspend operator fun invoke(value:Boolean) {
        return repository.setUiMode(value)
    }
}