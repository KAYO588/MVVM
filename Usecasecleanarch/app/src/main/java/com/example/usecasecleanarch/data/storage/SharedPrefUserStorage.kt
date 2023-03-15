package com.example.usecasecleanarch.data.storage

import android.content.Context
import com.example.usecasecleanarch.domain.model.SaveUserNameParamM
import com.example.usecasecleanarch.domain.model.UserName

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT = "default"

class SharedPrefUserStorage(private val context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME,user.firstName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"") ?: DEFAULT
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT) ?: DEFAULT

        return User(firstName = firstName,lastName = lastName)
    }
}