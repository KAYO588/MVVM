package com.example.usecasecleanarch.domain.UseCase

import com.example.usecasecleanarch.domain.model.SaveUserNameParamM
import com.example.usecasecleanarch.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParamM): Boolean{
        val result : Boolean = userRepository.saveName(saveName = param)
        return result

    }
}