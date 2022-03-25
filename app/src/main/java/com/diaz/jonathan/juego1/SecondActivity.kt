package com.diaz.jonathan.juego1

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    lateinit var musicF: MediaPlayer
    lateinit var usuarioR: EditText
    lateinit var btnVerificar: Button
    lateinit var musicC: MediaPlayer
    lateinit var musicI: MediaPlayer

    var numGen = 0
    var numUsuario = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        initUI()
        musicF = MediaPlayer.create(this,R.raw.mfondo)
        musicC = MediaPlayer.create(this,R.raw.aplausos)
        musicI = MediaPlayer.create(this,R.raw.errorn)
        playMusic()
        generaNum()

        btnVerificar.setOnClickListener(){
            val respuesta = usuarioR.text.toString()
            if (respuesta.equals("")){
                Toast.makeText(this, "Ingresa un valor", Toast.LENGTH_LONG).show()
                sonidoI()
            }else{
                numUsuario = respuesta.toInt()
                if (numGen == numUsuario){
                    sonidoC()
                }else{
                    sonidoI()
                    Toast.makeText(this, "El valor era $numGen", Toast.LENGTH_SHORT).show()
                }
                generaNum()
            }
        }

    }

    override fun onStop() {
        super.onStop()
        musicF.release()
        musicI.release()
        musicC.release()
    }

    fun playMusic(){
        musicF.isLooping = true
        musicF.setVolume(0.7f,0.7f)
        musicF.start()
    }
    fun sonidoC(){
        musicC.start()
    }
    fun sonidoI(){
        musicI.start()
    }

    fun initUI(){
        btnVerificar = findViewById(R.id.Verificar)
        usuarioR = findViewById(R.id.usuarioR)
    }
    fun generaNum(){
        numGen = Random.nextInt(1,10)
    }
}