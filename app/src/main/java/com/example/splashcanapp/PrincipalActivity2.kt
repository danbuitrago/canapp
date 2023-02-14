package com.example.splashcanapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class PrincipalActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal2)

        //setup()
        val bundle:Bundle?=intent.extras
        val email:String?=bundle?.getString("email")
        val provider:String?=bundle?.getString("provider")
        setup(email?:"",provider?:"")
    }
    private fun setup(email:String, provider:String){
        title="Inicio"
        //emailTextView.text=email
        //providerTextView.text=provider

        //logOutButtom.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

    }

//}