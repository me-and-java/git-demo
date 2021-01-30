package me.kaungmyatmin.carsdb

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class UserRepository {

    fun registerUser(context: Context, user: User) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val intent = MainActivity.newIntent(context)
                    context.startActivity(intent)
//                    context.finish()
                } else {
                    Toast.makeText(
                        context,
                        task.exception?.message ?: "Unknown Error",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
    }

    fun loginUser(context: Context, user: User) {

    }

    fun getUser(): User? {

        return null
    }

    fun isLogged(context: Context): Boolean {
        return false
    }

    fun saveLogged(context: Context) {


    }

    fun logout(context: Context) {

    }

    private fun showToast(
        context: Context,
        message: String
    ) {

    }
}
