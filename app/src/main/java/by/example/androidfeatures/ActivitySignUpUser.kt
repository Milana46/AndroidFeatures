package by.example.androidfeatures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.example.androidfeatures.databinding.ActivitySignUpUserBinding

class SignUpUserActivity : AppCompatActivity() {
    private  lateinit var binding:ActivitySignUpUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding= ActivitySignUpUserBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //пересмотретль логику активити 
        binding.button4.setOnClickListener{
            val intent= Intent(this@SignUpUserActivity,LocationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}