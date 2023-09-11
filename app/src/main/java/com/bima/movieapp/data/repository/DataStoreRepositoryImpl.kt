package com.bima.movieapp.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.bima.movieapp.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "ui_mode_preference")
class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
) : DataStoreRepository {


    override suspend fun setUiMode(value: Boolean) {
        val preferencesUiKey = booleanPreferencesKey("isDarkMode")
        context.dataStore.edit { pref->
            pref[preferencesUiKey] = value
        }
    }

    override suspend fun getUiMode(key: String): Flow<Boolean> {
        val preferencesUiKey = booleanPreferencesKey("isDarkMode")
        return context.dataStore.data.map {pref ->
            pref[preferencesUiKey] ?: false
        }
    }
}