package com.example.splashcanapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var authStateListener:FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        //splash
        //setContentView(R.layout.activity_main)
        //tiempo de espera
        startTimer()
        //pantalla de ingreso
        setContentView(R.layout.ingreso)
        //pantalla de bienvenido

        val btningresar:Button=findViewById(R.id.btnLogin)
        val txtemail:TextView=findViewById(R.id.txtEmail)
        val txtpass:TextView=findViewById(R.id.txtPass)

        //firebaseAuth=Firebase.auth

        btningresar.setOnClickListener()
        {
            signIn(txtemail.text.toString(),txtpass.text.toString())
        }

    }

    private fun signIn(email: String, password:String)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this)
        {
            task->if (task.isSuccessful){
                val user=firebaseAuth.currentUser
                Toast.makeText(baseContext,user?.uid.toString(),Toast.LENGTH_SHORT).show()
                //vamos a la segunda pantalla
            }
            else {Toast.makeText(baseContext, "Error", Toast.LENGTH_SHORT).show()}
        }
    }
    //TIEMPO DE ESPERA
    fun startTimer()        {
            object:CountDownTimer(3000,1000)
            {
                override fun onTick(millisUntilFinished: Long) {
                }
                override fun onFinish() {
                    val intent=Intent(applicationContext, PrincipalActivity2::class.java).apply{}
                    startActivity(intent)
                }
            }
                .start()
        }

    private fun showAlert()
    {
        val builder=AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog=builder.create()
        dialog.show()
    }


}