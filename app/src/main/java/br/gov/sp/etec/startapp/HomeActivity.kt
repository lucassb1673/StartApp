package br.gov.sp.etec.startapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intentVagasOcupadas = Intent(this, VagasOcupadasActivity::class.java)
        val intentVagasLivres = Intent(this, VagasLivresActivity::class.java)
        val intentEntrada = Intent(this, EntradaActivity::class.java)
        val intentSaida = Intent(this, SaidaActivity::class.java)
        val intentHistorico = Intent(this, HistoricoActivity::class.java)

        val btnVagasOcupadas = findViewById<Button>(R.id.buttonVagasOcupadas)
        btnVagasOcupadas.setOnClickListener {
            startActivity(intentVagasOcupadas)
        }

        val btnVagasLivres = findViewById<Button>(R.id.buttonVagasLivres)
        btnVagasLivres.setOnClickListener {
            startActivity(intentVagasLivres)
        }

        val btnEntrada = findViewById<Button>(R.id.buttonEntradas)
        btnEntrada.setOnClickListener {
            startActivity(intentEntrada)
        }

        val btnSaida = findViewById<Button>(R.id.buttonSaida)
        btnSaida.setOnClickListener {
            startActivity(intentSaida)
        }

        val btnHistorico = findViewById<Button>(R.id.buttonHistorico)
        btnHistorico.setOnClickListener {
            startActivity(intentHistorico)
        }
    }
}