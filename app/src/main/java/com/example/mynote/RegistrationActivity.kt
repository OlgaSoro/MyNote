package com.example.mynote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mynote.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var newlogin=binding.newloginet
        var newpassword=binding.newpasswordet
        var newregistraionbtn=binding.newregistrationbtn
        var backbtn=binding.backbtn

        newregistraionbtn.setOnClickListener{
            val newlogin=newlogin.text.toString()
            val newpassword=newpassword.text.toString()
            if (newlogin.isEmpty() || newpassword.isEmpty()){
                Toast.makeText(this, "Заполните все поля", Toast.LENGTH_SHORT)
            } else{
                val sharedPref=getSharedPreferences("LoginPref", Context.MODE_PRIVATE)
                val editor=sharedPref.edit()
                editor.putString("login", newlogin)
                editor.putString("password", newpassword)
                editor.apply()
                Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show()

            }
        }

        backbtn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}