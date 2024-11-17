package com.example.mynote

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.mynote.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val login=binding.loginet
        val password=binding.passwordet
        val enterbtn=binding.enterbtn
        val registration=binding.reget

        registration.setOnClickListener{
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

        enterbtn.setOnClickListener{
            val login=login.text.toString()
            val password=password.text.toString()

            val sharedPref=getSharedPreferences("LoginPref", MODE_PRIVATE)
            val savedLogin=sharedPref.getString("login", null)
            val savedPas=sharedPref.getString("password", null)

            if (login==savedLogin && password==savedPas) {
                Toast.makeText(this, "Добро пожаловать!", Toast.LENGTH_SHORT)
                startActivity(Intent(this, WorkActivity::class.java))
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
        val exitbtn=binding.exitbtn
        exitbtn.setOnClickListener{
            finishAffinity()
        }
    }


}