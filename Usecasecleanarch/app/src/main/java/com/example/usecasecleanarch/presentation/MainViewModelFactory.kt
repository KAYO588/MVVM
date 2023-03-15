package com.example.usecasecleanarch.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.usecasecleanarch.data.UserRepositoryImpl
import com.example.usecasecleanarch.data.storage.SharedPrefUserStorage
import com.example.usecasecleanarch.domain.UseCase.GetUserNameUseCase
import com.example.usecasecleanarch.domain.UseCase.SaveUserNameUseCase

class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy{ UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = context)) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository = userRepository) }
    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository = userRepository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(getUserNameUseCase = getUserNameUseCase, saveUserNameUseCase = saveUserNameUseCase) as T
    }
}