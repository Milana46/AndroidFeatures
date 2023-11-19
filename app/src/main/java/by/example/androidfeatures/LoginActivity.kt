package by.example.androidfeatures

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.example.androidfeatures.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.button4.setOnClickListener{
            val intent=Intent(this@LoginActivity,SignUpUserActivity::class.java)
            startActivity(intent)*/



        binding.button4.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpUserActivity::class.java)
            startActivity(intent)
            finish()

        }

    }

}