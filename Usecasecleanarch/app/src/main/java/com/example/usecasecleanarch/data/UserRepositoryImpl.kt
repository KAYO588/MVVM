package com.example.usecasecleanarch.data

import com.example.usecasecleanarch.data.storage.User
import com.example.usecasecleanarch.data.storage.UserStorage
import com.example.usecasecleanarch.domain.model.SaveUserNameParamM
import com.example.usecasecleanarch.domain.model.UserName
import com.example.usecasecleanarch.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage):UserRepository {



    override fun saveName(saveName: SaveUserNameParamM): Boolean {
        val user = User(firstName = saveName.name, lastName = "")
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        val userName = UserName(firtsName = user.firstName, lastName = user.lastName)
        return userName

    }


}