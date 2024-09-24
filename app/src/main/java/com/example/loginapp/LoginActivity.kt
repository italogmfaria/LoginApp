package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var editNome: EditText
    private lateinit var editPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editNome = findViewById(R.id.editNome)
        editPassword = findViewById(R.id.editPassword)
    }

    fun onSendMessage(view: View?) {
        val nome = editNome.text.toString()
        val senha = editPassword.text.toString()
        if ("italo" == nome && "123" == senha) {
            val intent = Intent(this, HomeActivity::class.java)
            val bundle = Bundle()
            bundle.putString("nome", "Ítalo")
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(this, "Nome e senha incorretos!", Toast.LENGTH_SHORT).show()
            editNome.text.clear()
            editPassword.text.clear()
        }
    }
}
