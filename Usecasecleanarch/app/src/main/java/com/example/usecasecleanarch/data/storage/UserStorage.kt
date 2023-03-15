package com.example.usecasecleanarch.data.storage

import com.example.usecasecleanarch.domain.model.SaveUserNameParamM
import com.example.usecasecleanarch.domain.model.UserName

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}