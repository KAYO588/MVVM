package com.example.usecasecleanarch.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usecasecleanarch.domain.UseCase.GetUserNameUseCase
import com.example.usecasecleanarch.domain.UseCase.SaveUserNameUseCase
import com.example.usecasecleanarch.domain.model.SaveUserNameParamM
import com.example.usecasecleanarch.domain.model.UserName

class MainViewModel(
    private val saveUserNameUseCase: SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
): ViewModel() {


    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive: LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "Vm created")
    }

    override fun onCleared() {
        Log.e("AAA", "Vm cleared")
        super.onCleared()
    }

    fun save(text: String){

        val params = SaveUserNameParamM(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
        resultLiveMutable.value = "$resultData"
    }

    fun load(){
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firtsName}, ${userName.lastName}"

    }

}