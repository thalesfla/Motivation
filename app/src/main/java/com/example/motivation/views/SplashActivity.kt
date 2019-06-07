package com.example.motivation.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.util.MotivationConstants
import com.example.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSecurity: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurity = SecurityPreferences(this)
        buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonSave) {
            handleSave()
        }
    }

    //funão para armazenar o nome na Sharedpreferences
    private fun handleSave() {
        val name: String = editName.text.toString()

        if (name == "") {
            Toast.makeText(this, getString(R.string.informe_nome), Toast.LENGTH_LONG).show()
        } else {
            mSecurity.storeString(MotivationConstants.KEY.PERSON_NAME, name)

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

            // Impede que seja possivel voltar a esta activity
            finish()
        }

    }
}
