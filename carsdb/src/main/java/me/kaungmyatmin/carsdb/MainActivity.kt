package me.kaungmyatmin.carsdb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolBar)

        val auth = FirebaseAuth.getInstance()

        val currentUser = auth.currentUser
        val email = currentUser?.zzc()?.email?:tvName.text.toString()
        tvName.text= email

    }

    private fun logout(){
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, SplashActivity::class.java))
        finishAffinity()
    }

}