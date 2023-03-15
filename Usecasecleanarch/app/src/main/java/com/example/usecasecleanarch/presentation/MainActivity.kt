package com.example.usecasecleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.usecasecleanarch.R
import com.example.usecasecleanarch.data.UserRepositoryImpl
import com.example.usecasecleanarch.data.storage.SharedPrefUserStorage
import com.example.usecasecleanarch.domain.UseCase.GetUserNameUseCase
import com.example.usecasecleanarch.domain.UseCase.SaveUserNameUseCase
import com.example.usecasecleanarch.domain.model.SaveUserNameParamM
import com.example.usecasecleanarch.domain.model.UserName

class MainActivity : AppCompatActivity() {

    private  lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        vm = ViewModelProvider(this, MainViewModelFactory(this))
            .get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val getButton = findViewById<Button>(R.id.getButton)
        val saveButton = findViewById<Button>(R.id.saveButton)

        vm.resultLive.observe(this, Observer { text ->
            dataTextView.text = text
        })

        saveButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }

        getButton.setOnClickListener {
        vm.load()

        }
    }
}