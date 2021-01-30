package me.kaungmyatmin.carsdb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvRegister.setOnClickListener {
            val intent = RegisterActivity.newIntent(this)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            when {
                email.isBlank() -> {
                    containerEmail.error = "User Name is required"
                }
                password.isBlank() -> {
                    containerPassword.error = "Password is required"
                }
                else -> {
                    /* val userRepository = UserRepository()
                     userRepository.loginUser(this, User(name, password))*/

                    FirebaseAuth.getInstance()
                        .signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()
                                startActivity(MainActivity.newIntent(this))
                                finish()
                            } else {
                                Toast.makeText(
                                    this,
                                    task.exception?.message ?: "Unknown Error",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }

                }
            }
        }
    }

}
