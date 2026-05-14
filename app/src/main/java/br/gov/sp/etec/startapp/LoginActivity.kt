package br.gov.sp.etec.startapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        val mainView = findViewById<android.view.View>(R.id.main)
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }

        val edittextEmailLogin = findViewById<EditText>(R.id.edittextEmailLogin)
        val edittextSenhaLogin = findViewById<EditText>(R.id.editTextSenhaLogin)
        val btnLogin = findViewById<Button>(R.id.buttonLogin)
        val btnCadastro = findViewById<Button>(R.id.buttonCadastrar)

        btnLogin.setOnClickListener {
            val email = edittextEmailLogin.text.toString()
            val senha = edittextSenhaLogin.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {

                Toast.makeText(this, "Ops! parece que você esqueceu de digitar", Toast.LENGTH_LONG).show()
            } else {
                // Corrigido: Comparando email E senha separadamente
                if (email == "teste@teste.com" && senha == "123456") {
                    val intentHome = Intent(this, HomeActivity::class.java)
                    startActivity(intentHome)
                    finish() // Opcional: fecha a tela de login ao entrar na Home
                } else {
                    Toast.makeText(this, "Usuário ou senha inválido", Toast.LENGTH_LONG).show()
                }
            }
        }

        btnCadastro.setOnClickListener {
            val intentCadastra = Intent(this, CadastroActivity::class.java)
            startActivity(intentCadastra)
        }
    }
}