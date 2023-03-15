package com.example.usecasecleanarch.domain.UseCase

import com.example.usecasecleanarch.domain.model.UserName
import com.example.usecasecleanarch.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        val result = userRepository.getName()
        return result
    }
}