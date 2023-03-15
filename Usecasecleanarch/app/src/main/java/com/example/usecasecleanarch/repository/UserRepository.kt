package com.example.usecasecleanarch.repository

import com.example.usecasecleanarch.domain.model.SaveUserNameParamM
import com.example.usecasecleanarch.domain.model.UserName

interface UserRepository {
    
    fun getName(): UserName

    fun saveName(saveName: SaveUserNameParamM): Boolean


}